package com.example.jasper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.example.jasper.dao.TestDao;
import com.example.jasper.dto.InvoiceOrderDto;
import com.example.jasper.dto.MailRequest;
import com.example.jasper.dto.MailResponse;
import com.example.jasper.dto.OrderRequest;
import com.example.jasper.entity.customer;
import com.example.jasper.entity.orderc;
import com.example.jasper.repository.customerRepository;
import com.example.jasper.repository.orderRepository;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.util.Random;

@Service
public class JasperTestService {
	
	@Autowired
	private customerRepository customerRepo;
	
	@Autowired
	private orderRepository ordrRepo;
	
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private TestDao testDao;
	
	@Autowired
	private Configuration config;
	
	public List<customer> getAll() throws Exception{
		exportReport("pdf");
		 List<customer> findAll = customerRepo.findAll();
        String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS'.txt'").format(new Date());
        System.out.println(fileName);
        return findAll;
		
	}
	
	
	public List<customer> getAllOnly() {
		 List<customer> findAll = customerRepo.findAll();
        return findAll;
		
	}
	
	public customer getOne(Integer id) {
		 Optional<customer> customerOptional = customerRepo.findById(id);
		 customer cus = customerOptional.isPresent() ? customerOptional.get() : new customer() ;
		 return cus;		
	}
	
	public String saveCustomer(customer cust) {
		
		customerRepo.save(cust);
		return "success";
	}
	
	public String saveOrder(OrderRequest ordrReq) {
		
		Optional<customer> optionalCustomer = customerRepo.findByContactNumber(ordrReq.getMobileno());
		customer cus = optionalCustomer.isPresent() ? optionalCustomer.get() : null;
		
		if ((cus.getOtp().toString()).equals(ordrReq.getOtp().toString())) {
			int year = ordrReq.getDate().getYear();
			int month = ordrReq.getDate().getMonth();
			orderc ord = new orderc();
			ord.setCus(cus);
			ord.setAmount(ordrReq.getAmount());
			ord.setOrderdate(ordrReq.getDate());	
			ordrRepo.save(ord);
			
			List<InvoiceOrderDto> invoidOrdersList =     new ArrayList<>();
			InvoiceOrderDto ior = new InvoiceOrderDto();
			ior.setOrderId(0);
			ior.setDescription("milk order -"+testDao.make_date_format(ordrReq.getDate()));
			
	        BigDecimal itemPrice = new BigDecimal("250.00");
			BigDecimal totalPrice = itemPrice.multiply(new BigDecimal(ordrReq.getAmount()));
			ior.setQuantity(ordrReq.getAmount());
			ior.setTotal(totalPrice.toString());
			
			invoidOrdersList.add(ior);
			
			sendEmailInvoice(ordrReq.getMobileno(),invoidOrdersList);
			
		}else {
			return "fail";
		}

		return "success";
	}
	
	
	

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "E:\\test\\Report";
        List<customer> employees = customerRepo.findAll();
        //load file and compile it
        //File file = ResourceUtils.getFile("classpath:customers_test1.jrxml");
        InputStream file = getClass().getResourceAsStream("/customers_test1.jrxml");
        //JasperDesign jasperDesign = JRXmlLoader.load(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(file);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\customer"+getFormatedCurrentTimeForNote()+".html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
        	
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\customer.pdf");
        }


        return "report generated in path : " + path;
    }
    
    
    public JasperPrint downloadPdf() throws FileNotFoundException, JRException {
        String path = "E:\\test\\Report";
        List<customer> employees = customerRepo.findAll();
        //load file and compile it
        //File file = ResourceUtils.getFile("classpath:customers_test1.jrxml");
        InputStream file = getClass().getResourceAsStream("/customers_test1.jrxml");
        //JasperDesign jasperDesign = JRXmlLoader.load(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(file);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);


        return jasperPrint;
    }
    
    private static final String DATE_FORMAT_TIME = "yyyy-MM-dd HH:mm";
	public static String getFormatedCurrentTimeForNote() {
		try {
			LocalDateTime currentDate = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT_TIME);
			return dtf.format(currentDate);
		} catch (Exception e) {
			return null;
		}
	}
	

	
	public MailResponse sendEmail(int mobile) {
		
		
		int otp =getRandomOtpNumber();
		
		Optional<customer> optionalCustomer = customerRepo.findByContactNumber(mobile);
		customer cus = optionalCustomer.isPresent() ? optionalCustomer.get() : null;
		
		cus.setOtp(otp);
		customerRepo.save(cus);
		
		MailRequest request = new MailRequest();
		request.setFrom("dilhanajmn@12gmail.com");
		request.setTo(cus.getEmail());
		request.setName(" nipun dilhan ");
		request.setSubject(" otp verification ");
		
		Map<String, Object> model = new HashMap<>();
		model.put("mobile", cus.getContactno());
		model.put("otp", otp);
		
		MailResponse response = new MailResponse();
		MimeMessage message = sender.createMimeMessage();
		try {
			// set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());


			String templateStr="<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<title>Page Title</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"<h1>This is your mobile</h1>\r\n" + 
					"<p><b>${mobile}</b></p>\r\n" + 
					"<h1>This is your otp</h1>\r\n" + 
					"<p><b>${otp}</b></p>\r\n" + 
					"</body>\r\n" + 
					"</html>";
			
			Template t = new Template("name", new StringReader(templateStr),config);
			
			//Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			helper.setTo(request.getTo());
			helper.setText(html, true);
			helper.setSubject(request.getSubject());
			helper.setFrom(request.getFrom());
			sender.send(message);

			response.setMessage("mail send to : " + request.getTo());
			response.setStatus(Boolean.TRUE);

		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail Sending failure : "+e.getMessage());
			response.setStatus(Boolean.FALSE);
		}

		return response;
	}
	
	
	private int getRandomOtpNumber() {
		
        Random rand = new Random();
        
        // rand.nextInt(9) Generate random integers in range 0 to 8
        int x = (rand.nextInt(9)+1)*1000 + rand.nextInt(1000);
        
        return x;
      
	}
	
	
    public JasperPrint ordersReport() throws FileNotFoundException, JRException {
        String path = "E:\\test\\Report";
        List<orderc> ordersList = ordrRepo.findAll();
        List<InvoiceOrderDto> invoidOrdersList =     new ArrayList<>();
        
        //load file and compile it
        //File file = ResourceUtils.getFile("classpath:customers_test1.jrxml");
        InputStream file = getClass().getResourceAsStream("/inovoice_test1.jrxml");
        //JasperDesign jasperDesign = JRXmlLoader.load(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(file);
       // JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ordersList);
        
        Integer totalItems = 0;
        BigDecimal itemPrice = new BigDecimal("250.00");
        
        for(orderc ordr: ordersList) {
        	InvoiceOrderDto invcOrdr = new InvoiceOrderDto();
        	invcOrdr.setDescription(" ");
        	invcOrdr.setOrderId(ordr.getOrderid());
        	invcOrdr.setQuantity(ordr.getAmount());
        	invcOrdr.setTotal(itemPrice.multiply(new BigDecimal(ordr.getAmount())).toString());
        	
        	invoidOrdersList.add(invcOrdr);
        	
        	totalItems += ordr.getAmount();
        }
        BigDecimal totalAmount = itemPrice.multiply(new BigDecimal(totalItems));
        
    	InvoiceOrderDto invcOrdr = new InvoiceOrderDto();
    	invcOrdr.setDescription("Totals  ");
    	invcOrdr.setOrderId(null);
    	invcOrdr.setQuantity(totalItems);
    	invcOrdr.setTotal(totalAmount.toString());
        
    	invoidOrdersList.add(invcOrdr);
        
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("ReportTitle", "List of Contacts");
        parameters.put("month", "june");

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoidOrdersList);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);


        return jasperPrint;
    }
    
    
	public MailResponse sendEmailInvoice(int mobile ,List<InvoiceOrderDto> invoidOrdersList) {
		
		
		Optional<customer> optionalCustomer = customerRepo.findByContactNumber(mobile);
		customer cus = optionalCustomer.isPresent() ? optionalCustomer.get() : null;
		
		
		MailRequest request = new MailRequest();
		request.setFrom("dilhanajmn@12gmail.com");
		request.setTo(cus.getEmail());
		request.setName(" nipun dilhan ");
		request.setSubject(" otp verification ");
		
		Map<String, Object> model = new HashMap<>();
		model.put("Name", "nipun");
		model.put("location", "meegoda");
		model.put("students", invoidOrdersList);
		
		MailResponse response = new MailResponse();
		MimeMessage message = sender.createMimeMessage();
		try {
			// set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());


			String templateStr="<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
					"<head>\r\n" + 
					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
					"<title>Java Techie Mail</title>\r\n" + 
					"<style>\r\n" + 
					"table {\r\n" + 
					"  border-collapse: collapse;\r\n" + 
					"  width: 100%;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"th, td {\r\n" + 
					"  text-align: left;\r\n" + 
					"  padding: 8px;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"tr:nth-child(even){background-color: #f2f2f2}\r\n" + 
					"\r\n" + 
					"th {\r\n" + 
					"  background-color: #4CAF50;\r\n" + 
					"  color: white;\r\n" + 
					"}\r\n" + 
					"</style>\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"<body>\r\n" + 
					"	<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
					"		<tr>\r\n" + 
					"			<td align=\"center\" valign=\"top\" bgcolor=\"#838383\"\r\n" + 
					"				style=\"background-color: #838383;\"><br> <br>\r\n" + 
					"				<table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
					"					<tr>\r\n" + 
					"						<td align=\"center\" valign=\"top\" bgcolor=\"#d3be6c\"\r\n" + 
					"							style=\"background-color:#6699ff; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color: #000000; padding: 0px 15px 10px 15px;\">\r\n" + 
					"							\r\n" + 
					"							<div style=\"font-size: 48px; color:blue;\">\r\n" + 
					"								<table border=1> \r\n" + 
					"									 <tr>\r\n" + 
					"    									<th>id</th>\r\n" + 
					"    									<th>name</th>\r\n" + 
					"                                        <th>amount</th>\r\n" + 
					"                                        <th>price</th>\r\n" + 
					" 									 </tr>\r\n" + 
					" 									 <#list students as stdnt>\r\n" + 
					"    									<tr><td>${stdnt.orderId}<td>${stdnt.description} <td>${stdnt.quantity} <td>${stdnt.total} \r\n" + 
					" 									 </#list>\r\n" + 
					"								</table>\r\n" + 
					"							</div>\r\n" + 
					"							\r\n" + 
					"\r\n" + 
					"							<div>\r\n" + 
					"								\r\n" + 
					"								<br>\"Sharing the knowledge is biggest learning\" <br> <br>\r\n" + 
					"								<br> <br> <b>${Name}</b><br>${location}<br>\r\n" + 
					"								<br>\r\n" + 
					"							</div>\r\n" + 
					"						</td>\r\n" + 
					"					</tr>\r\n" + 
					"				</table> <br> <br></td>\r\n" + 
					"		</tr>\r\n" + 
					"	</table>\r\n" + 
					"</body>\r\n" + 
					"</html>";
			
			Template t = new Template("name", new StringReader(templateStr),config);
			
			//Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			helper.setTo(request.getTo());
			helper.setText(html, true);
			helper.setSubject(request.getSubject());
			helper.setFrom(request.getFrom());
			sender.send(message);

			response.setMessage("mail send to : " + request.getTo());
			response.setStatus(Boolean.TRUE);

		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail Sending failure : "+e.getMessage());
			response.setStatus(Boolean.FALSE);
		}

		return response;
	}
}

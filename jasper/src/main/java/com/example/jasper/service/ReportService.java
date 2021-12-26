package com.example.jasper.service;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.jasper.dao.TestDao;
import com.example.jasper.dto.AreaOrderDto;
import com.example.jasper.dto.InvoiceOrderDto;
import com.example.jasper.dto.SearchByAreaDateRequest;
import com.example.jasper.entity.area;
import com.example.jasper.entity.orderc;
import com.example.jasper.repository.areaRepository;
import com.example.jasper.repository.orderRepository;
import com.example.jasper.wrapper.AreaOrderRespDto;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	
	String[] monthnames = {"No month", "January", "February", "March", "April", "May","June", "July", "August", "September","Octomber", "November", "December"};
	int[] monthNo = {1,2,3,4,5,6,7,8,9,10,11,12};
	
	@Autowired
	private orderRepository ordrRepo;
	
	@Autowired
	private areaRepository areaRepo;
	
	@Autowired
	private TestDao testDao;
	
	public void getYearReport(int year) throws JRException {
		
		String reportFormat = "pdf";
        String path = "E:\\test\\Report";
		
		 List<InvoiceOrderDto> invoidOrdersList =     new ArrayList<>();
		
        Integer totalItems = 0;
        BigDecimal itemPrice = new BigDecimal("250.00");
        
        for(int mnth: monthNo) {
        	int findTotalAmountByYearMonth = ordrRepo.findTotalAmountByYearMonth(mnth, year);
        	
        	InvoiceOrderDto invcOrdr = new InvoiceOrderDto();
        	invcOrdr.setDescription(monthnames[mnth]);
        	invcOrdr.setOrderId(null);
        	invcOrdr.setQuantity(findTotalAmountByYearMonth);
        	invcOrdr.setTotal(itemPrice.multiply(new BigDecimal(findTotalAmountByYearMonth)).toString());
        	
        	invoidOrdersList.add(invcOrdr);
        	
        	totalItems += findTotalAmountByYearMonth;
        }
        BigDecimal totalAmount = itemPrice.multiply(new BigDecimal(totalItems));
        
    	InvoiceOrderDto invcOrdr = new InvoiceOrderDto();
    	invcOrdr.setDescription("Totals  ");
    	invcOrdr.setOrderId(null);
    	invcOrdr.setQuantity(totalItems);
    	invcOrdr.setTotal(totalAmount.toString());
        
    	invoidOrdersList.add(invcOrdr);
    	
        InputStream file = getClass().getResourceAsStream("/inovoice_test1.jrxml");
        //JasperDesign jasperDesign = JRXmlLoader.load(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(file);
        
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("ReportTitle", String.valueOf(year));
        parameters.put("month"," " );

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoidOrdersList);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);


        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\year.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
        	
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\year.pdf");
        }
		
		
	}
	
	public String getMonthDetails(int year, int month) throws JRException {
		
		String reportFormat = "pdf";
        String path = "E:\\test\\Report";
		
		List<orderc> findByYearMonth = ordrRepo.findByYearMonth(month, year);
		

        List<InvoiceOrderDto> invoidOrdersList =     new ArrayList<>();
        
        InputStream file = getClass().getResourceAsStream("/inovoice_test1.jrxml");
        //JasperDesign jasperDesign = JRXmlLoader.load(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(file);
        
        Integer totalItems = 0;
        BigDecimal itemPrice = new BigDecimal("250.00");
        
        for(orderc ordr: findByYearMonth) {
        	InvoiceOrderDto invcOrdr = new InvoiceOrderDto();
        	invcOrdr.setDescription( " " );
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

        parameters.put("ReportTitle", String.valueOf(year));
        parameters.put("month",monthnames[month] );

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoidOrdersList);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);


        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\yearmonth.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
        	
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\yearmonth.pdf");
        }


        return "report generated in path : " + path;
		
	}
	
	
	public String getAreaOrders(SearchByAreaDateRequest req) throws JRException {
		
		List<AreaOrderRespDto> searchOrders = testDao.searchOrders(req);
		
		String reportFormat = "pdf";
        String path = "E:\\test\\Report";
		

        List<AreaOrderDto> invoidOrdersList =     new ArrayList<>();
        
        InputStream file = getClass().getResourceAsStream("/area_order.jrxml");
        //JasperDesign jasperDesign = JRXmlLoader.load(file);
        JasperReport jasperReport = JasperCompileManager.compileReport(file);
        
        Integer totalItems = 0;
        BigDecimal itemPrice = new BigDecimal("250.00");
        
        for(AreaOrderRespDto ordr: searchOrders) {
        	AreaOrderDto invcOrdr = new AreaOrderDto();
        	invcOrdr.setCustomer(ordr.getNamecustomer()+" ("+ordr.getContactno()+")");
        	invcOrdr.setAddress(ordr.getAddress());
        	invcOrdr.setContact(ordr.getContactno());
        	invcOrdr.setAmount(ordr.getAmount());
        	invcOrdr.setTotal(ordr.getTotalprice());
        	
        	invoidOrdersList.add(invcOrdr);
        	
        	totalItems += ordr.getAmount();
        }
        BigDecimal totalAmount = itemPrice.multiply(new BigDecimal(totalItems));
        
    	AreaOrderDto invcOrdr = new AreaOrderDto();
    	invcOrdr.setCustomer("Totals");
    	invcOrdr.setAddress("");
    	invcOrdr.setContact(" ");
    	invcOrdr.setAmount(totalItems);
    	invcOrdr.setTotal(totalAmount.toString());
    	
    	invoidOrdersList.add(invcOrdr);
    	
    	
        
        Map<String, Object> parameters = new HashMap<>();
        
        Optional<area> areaOptional = areaRepo.findById(req.getAreaid());
        area area = areaOptional.get();
        String areaname = area.getAreaname();
        String dateorder = testDao.make_date_format(req.getDate());
        String reporttitle = areaname+ " - " +dateorder;

        parameters.put("ReportTitle", reporttitle);
        parameters.put("month", "");

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoidOrdersList);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);


        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\area.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
        	
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\area.pdf");
        }


        return "report generated in path : " + path;
		
	}
	
	

}

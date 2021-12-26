package com.example.jasper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.jasper.dto.MobileOTPrequest;
import com.example.jasper.dto.OrderRequest;
import com.example.jasper.dto.SearchByAreaDateRequest;
import com.example.jasper.dto.SearchYearMonthRequest;
import com.example.jasper.dto.SerachYearRequest;
import com.example.jasper.entity.customer;
import com.example.jasper.service.JasperTestService;
import com.example.jasper.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home	() throws Exception {
		return "index";
	}
	
	@Autowired
	private JasperTestService jasTestService;
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping("/customers")
	public String getdetails(Model model){

		 List<customer> customerList = jasTestService.getAllOnly();
		 model.addAttribute("cstmrs", customerList);
		 return "customers";
	}
	
	@GetMapping("/cstmr")
	public String getOne(Integer id,Model model){

		customer one = jasTestService.getOne(id);
		model.addAttribute("cst", one);
		return "customer";
	}
	
	
	@PostMapping("/add-new")
	public String saveNew(customer cust){

		jasTestService.saveCustomer(cust);
		return "redirect:/customers";
	}
	
	@GetMapping("/add-page")
	public String saveNewPage(){		
		return "addCustomer";
	}
	
	@GetMapping("/date-enter")
	public String dataEnterPage(){		
		return "dataEnterFrom";
	}
	
	
	@PostMapping("/mobile-otp")
	public String generateOtp(MobileOTPrequest request){
		System.out.println(request.getMobileNo());
		jasTestService.sendEmail(request.getMobileNo());
		return "OrderEnter";
	}
	
	@PostMapping("/order")
	public String order(OrderRequest request){
		System.out.println(request.getAmount());
		System.out.println(request.getMobileno());
		System.out.println(request.getOtp());
		System.out.println(request.getDate());
		

		
		
		
		
		jasTestService.saveOrder(request);
		return "dataEnterFrom";
	}
	
	
	@GetMapping("/get-search-page-year-month")
	public String dataSearchYearMonth(){		
		return "searchYearMonth";
	}
	
	@PostMapping("/search-year-month")
	public String searchYearMonth(SearchYearMonthRequest request) throws JRException{

		reportService.getMonthDetails(request.getYear(), request.getMonth());
		//jasTestService.sendEmail(request.getMobileNo());
		return "searchYearMonth";
	}
	
	
	@GetMapping("/get-search-page-year")
	public String dataSearchYear(){		
		return "searchYear";
	}
	
	@PostMapping("/search-year")
	public String searchYear(SerachYearRequest request) throws JRException{

		reportService.getYearReport(request.getYear());
		return "searchYear";
	}
	
	@GetMapping("/get-search-date-area")
	public String dataSearchDateArea(){		
		return "areaOrders";
	}
	
	@PostMapping("/search-area")
	public String searchArea(SearchByAreaDateRequest request) throws JRException{

		reportService.getAreaOrders(request);
		return "areaOrders";
	}
	
	
	
	

}

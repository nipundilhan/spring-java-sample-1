package com.example.jasper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.jasper.entity.customer;
import com.example.jasper.service.JasperTestService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

@RestController // This means that this class is a Controller
@RequestMapping("/jasper")
public class JasperTestController {
	
	@Autowired
	private JasperTestService jasTestService;
	
	@GetMapping("/customers")
	public List<customer> getdetails() throws Exception {

		return jasTestService.getAll();
	}
	
	

	
	 @GetMapping(value = "/export")
	 public void export(ModelAndView model, HttpServletResponse response) throws IOException, JRException, SQLException {
	  JasperPrint jasperPrint = null;

	  response.setContentType("application/x-download");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"users.pdf\""));

	  OutputStream out = response.getOutputStream();
	  jasperPrint = jasTestService.downloadPdf();
	  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	 }
	
	 
	 @GetMapping(value = "/export-orders")
	 public void exportOrders(ModelAndView model, HttpServletResponse response) throws IOException, JRException, SQLException {
	  JasperPrint jasperPrint = null;

	  response.setContentType("application/x-download");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"orders.pdf\""));

	  OutputStream out = response.getOutputStream();
	  jasperPrint = jasTestService.ordersReport();
	  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	 }
	


}

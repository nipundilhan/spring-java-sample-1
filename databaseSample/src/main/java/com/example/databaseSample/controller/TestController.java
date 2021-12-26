package com.example.databaseSample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.databaseSample.dto.CustomResp1;
import com.example.databaseSample.entity.student;
import com.example.databaseSample.entity.vstdcrse;
import com.example.databaseSample.repository.studentRepository;
import com.example.databaseSample.repository.vstdcrseRepository;
import com.example.databaseSample.request.TestRequest1;
import com.example.databaseSample.service.TestService;

@RestController // This means that this class is a Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired 
	private TestService testService;
	
	@Autowired
	private studentRepository studentRepo;
	
	@Autowired
	private vstdcrseRepository vstdcrseRepo;

	@GetMapping("/get-details")
	public List<student> getdetails() {

		return testService.getDetails();
	}
	
	@GetMapping("/pagination")
	public  Page<student> pagination() {
		
		return testService.getPagination();
	}
	
	@GetMapping("/hello")
	public String hello() {
		
		return "hello world";
	}
	
	@GetMapping("/jpa-query1")
	public List<student> getStudentRepo() {
		
		return studentRepo.getStudentWithCourseStudentId();
	}
	
	@GetMapping("/jpa-query2")
	public List<CustomResp1> getStudentRepo2() {
		
		List<CustomResp1> joinInformations = studentRepo.getJoinInformations();

		
//		String names = "";
//		if(!joinInformations.isEmpty()) {
//			for(CustomResp1 item:joinInformations) {
//				names = names+" | "+item.getFirstname() +" - "+ item.getLastname() + " | ";
//			}
//		}
		
		//return names;
		return joinInformations;
	}
	
	@GetMapping("/view1")
	public List<vstdcrse> getdetailsView() {
		
		return vstdcrseRepo.findAll();
		
	}
	
	
	@PostMapping("/dynamic")
	public List<student> getDynamicCondition(@RequestBody  TestRequest1 request) {
		
		return studentRepo.getStudentDynamicCondition(request.getFirstNm(), request.getLastNm(), request.getContactVl());
	}
	

}

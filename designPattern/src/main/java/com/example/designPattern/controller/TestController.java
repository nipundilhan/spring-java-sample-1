package com.example.designPattern.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.designPattern.request.StudentReq;
import com.example.designPattern.response.StudentDto;

@RestController
@RequestMapping("/test")
public class TestController {
	
	
	 @PostMapping("/std")
	public StudentDto test(@RequestBody StudentReq req) {
		 
		StudentDto response = new StudentDto();
		response.setName(req.getName());
		response.setAge(req.getAge());
		response.setGrade("10");
		response.setSchool("isipathana");
		return  response;
	}

}

package com.example.dbsample1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbsample1.entity.student;
import com.example.dbsample1.repository.studentRepository;

@RestController
@RequestMapping("/direct2")
public class DirectRepoController2 {
	
	@Autowired
	private ApplicationContext context;

	
	@GetMapping("/students")
	public String getSchools() {
		Object obj = context.getBean(studentRepository.class);
		
		System.out.println("object ==========> "+obj);
		//return stdRep.findById(1).get().getFirstname();
		return "hiranya";
	}
	

}

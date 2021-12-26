package com.example.dbsample1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbsample1.entity.course;
import com.example.dbsample1.entity.highschool;
import com.example.dbsample1.entity.student;
import com.example.dbsample1.repository.studentRepository;
import com.example.dbsample1.service.CrudServiceImpl;



@RestController
@RequestMapping("/direct1")
public class DirectRepoController1 {
		
	@Autowired
	private ApplicationContext context;

	
	@GetMapping("/students")
	public Long getSchools() {
		Object obj = context.getBean(studentRepository.class);
		
		System.out.println("object ==========> "+obj);
		return 6l;
	}

}

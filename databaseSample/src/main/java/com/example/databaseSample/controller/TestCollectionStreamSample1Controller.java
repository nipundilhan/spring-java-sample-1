package com.example.databaseSample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.databaseSample.entity.student;
import com.example.databaseSample.service.TestCollectionStreamSampleService1;

@RestController
@RequestMapping("/collection-streams")
public class TestCollectionStreamSample1Controller {
	
	@Autowired
	private TestCollectionStreamSampleService1 testService1;
	
	@GetMapping("/sample-1")
	public List<student> sample1() {
		return testService1.collectionStreamSample1();
	}

}

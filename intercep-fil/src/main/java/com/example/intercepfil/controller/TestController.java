package com.example.intercepfil.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intercepfil.service.TestService;

@RestController
@RequestMapping("/jar")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/test-1")
	public String getwork(){
		return testService.drawShape();
	}

}

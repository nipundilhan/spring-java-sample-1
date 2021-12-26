package com.example.EmailTest1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmailTest1.dto.MailRequest;
import com.example.EmailTest1.dto.MailResponse;
import com.example.EmailTest1.dto.StudentDto;
import com.example.EmailTest1.service.EmailService;

@RestController
@RequestMapping("/freemarker")
public class TestEmailController {

	@Autowired
	private EmailService service;

	@GetMapping("/sendingEmail")
	public MailResponse sendEmail() {
		MailRequest request = new MailRequest();
		request.setFrom("dilhanajmn@12gmail.com");
		request.setTo("nipundilhanjayarathne@gmail.com");
		request.setName(" nipun dilhan ");
		request.setSubject(" notification ");
		
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", "Bangalore,India");
		return service.sendEmail(request, model);

	}
	
	@GetMapping("/emailtable")
	public MailResponse emailTable() {
		MailRequest request = new MailRequest();
		request.setFrom("dilhanajmn@12gmail.com");
		request.setTo("nipundilhanjayarathne@gmail.com");
		request.setName(" nipun dilhan ");
		request.setSubject(" notification ");
		
		Map<String, Object> model = new HashMap<>();
		
		List<StudentDto> stdList = new ArrayList<>();
		StudentDto s1 = new StudentDto("1","nimal");
		StudentDto s2 = new StudentDto("2","sadun");
		StudentDto s3 = new StudentDto("3","kamal");
		StudentDto s4 = new StudentDto("4","amal");
		
		stdList.add(s1);stdList.add(s2);stdList.add(s3);stdList.add(s4);
		
		model.put("Name", request.getName());
		model.put("location", "Bangalore,India");
		model.put("students", stdList);
		return service.sendEmailTable(request, model);

	}
}

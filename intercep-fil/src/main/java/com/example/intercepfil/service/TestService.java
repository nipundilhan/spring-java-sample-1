package com.example.intercepfil.service;

import org.springframework.stereotype.Service;

import com.simplejar.Student;

import smpl.service.DecideShape;
import smpl.service.ServiceShapeService;
import smpl.service.ServiceShapeServiceImpl;
import smpl.service.Shape;
import smpl.srvc.WorkService;
import smpl.srvc.WorkServiceImpl;

@Service
public class TestService {
	
	public String getStudentWork() {
		
		Student s = new Student("nipun",10);
		return s.work("maths");
		
	}
	
	
	public String work() {
		
		WorkService ws = new WorkServiceImpl();
		return ws.work1("SE");
	}
	
	public String drawShape() {
		
		ServiceShapeService sss = new ServiceShapeServiceImpl();
		return sss.shapedraw("SQR");
	}

}

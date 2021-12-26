package com.example.aoplog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aoplog.advice.TrackExecutionTime;


@RestController
@RequestMapping("/debug")
public class TestController1 {
	
	//Logger logger = LoggerFactory.getLogger("UpperDebugLevelLogger");
	
	@GetMapping("/getdebug")
	public String getDebug() {
		
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
//		logger.info("debug custom info logger");
//		logger.error("debug custom error logger");
//		logger.debug("debug custom debug logger");
		return "success";
	}
	
	
	@GetMapping("/gettime/{time}")
	@TrackExecutionTime
	public String getTime(@PathVariable long time) {
		
		for(int i = 0 ; i < time ; i++) {
			System.out.println("executing--------------------"+i);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};		
		}
		
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
//		logger.info("debug custom info logger");
//		logger.error("debug custom error logger");
//		logger.debug("debug custom debug logger");
		return "success";
	}

}
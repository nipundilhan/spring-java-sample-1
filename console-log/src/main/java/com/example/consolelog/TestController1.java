package com.example.consolelog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController1 {
	
	//Logger logger = LoggerFactory.getLogger("UpperDebugLevelLogger");
	
	@GetMapping("/method")
	public String getPrint() {		
		System.out.println("method invoked ...........");
		return "simple log";
		
	}
	
}

package com.example.EmailTest1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {
	
	@GetMapping("/hello")
	public String test123(){
		return "test success";
		
		
	}

}

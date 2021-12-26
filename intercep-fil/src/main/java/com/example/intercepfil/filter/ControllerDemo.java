package com.example.intercepfil.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class ControllerDemo {
	
	
	@GetMapping("/products")
	public List<String> listProducts(){
		List<String> nameList = Arrays.asList("Electronic", "Food","Furniture","Electrical");
		return nameList;
	}
	
	@GetMapping("/specific-url-pattern")
	public List<String> listUsers(){
		List<String> nameList = Arrays.asList("Hirasha", "Hiranya","Sahan","Anupama");
		return nameList;
	}

}

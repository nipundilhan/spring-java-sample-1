package com.example.intercepfil.interceptor;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/intercep")
public class ProductController1 {
	
	@GetMapping("/products")
	public List<String> listProducts(){
		List<String> nameList = Arrays.asList("Electronic", "Food","Furniture","Electrical");
		return nameList;
	}
	
	

}

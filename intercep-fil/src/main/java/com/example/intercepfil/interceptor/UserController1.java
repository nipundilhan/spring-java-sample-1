package com.example.intercepfil.interceptor;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/intercep")
public class UserController1 {
	
	@GetMapping("/users")
	public List<String> listProducts(){
		List<String> nameList = Arrays.asList("Hirasha", "Hiranya","Sahan","Anupama");
		return nameList;
	}

}

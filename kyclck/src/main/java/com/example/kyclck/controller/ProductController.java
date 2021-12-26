package com.example.kyclck.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kyclck.models.Products;
import com.example.kyclck.util.UserUtil;

@RestController
@RequestMapping("/products") 
public class ProductController {
	
	@Autowired
	private UserUtil userUtil;
	
	private List<Products> list = new ArrayList<>();
	
	@GetMapping("/get-all")
	@PreAuthorize("hasAuthority('ACTION_1_PERMISSION')")
	public List<Products> getAll(){
		
		System.out.println(userUtil.getOrgId());
		System.out.println(userUtil.getUserId());
		
		list.add(new Products("1","book"));
		list.add(new Products("1","pencile"));
		
		return list;
		
	}
	
	@GetMapping("/get-all-1")
	@PreAuthorize("hasAuthority('NONE')")
	public List<Products> getAll1(){
		list.add(new Products("1","book"));
		list.add(new Products("1","pencile"));
		
		return list;
		
	}
	

}

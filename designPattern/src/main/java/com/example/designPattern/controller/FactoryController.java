package com.example.designPattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.designPattern.dao.Shape;
import com.example.designPattern.response.ShapeResponseDto;
import com.example.designPattern.service.FactoryDemoServiceImpl;

@RestController
@RequestMapping("/fac")
public class FactoryController {
	
	@Autowired
	private FactoryDemoServiceImpl factoryService;
	
	 @GetMapping("/demo-shp")
	public String test() {
		return  "Hello";
	}
	
	 @GetMapping("/demo-shape/{shp}")
	public ShapeResponseDto shapeDemo(@PathVariable("shp") String shp) {
		return  factoryService.demo(shp);
	}

}

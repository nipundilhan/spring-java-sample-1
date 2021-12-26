package com.example.designPattern.dao.impl;

import org.springframework.stereotype.Component;

import com.example.designPattern.dao.Shape;
import com.example.designPattern.response.ShapeResponseDto;

@Component
public class Rectangle implements Shape{
	
	public ShapeResponseDto draw() {
		System.out.println("Inside rectangle::draw() method.");
		ShapeResponseDto response = new ShapeResponseDto();
		response.setShapeName("rectangle");
		return response;
	}

}

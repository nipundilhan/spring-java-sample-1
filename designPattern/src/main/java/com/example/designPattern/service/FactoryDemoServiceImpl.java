package com.example.designPattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.designPattern.dao.Shape;
import com.example.designPattern.dao.impl.Rectangle;
import com.example.designPattern.factory.ShapeFactory;
import com.example.designPattern.response.ShapeResponseDto;

@Service
public class FactoryDemoServiceImpl {
	
	@Autowired
	private ShapeFactory shapeFactory;
	
	public ShapeResponseDto demo(String shp) {
		Shape shape = shapeFactory.getShape(shp);
		return shape.draw();
		
	}

}

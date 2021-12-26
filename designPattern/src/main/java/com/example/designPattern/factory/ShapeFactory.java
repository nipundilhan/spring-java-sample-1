package com.example.designPattern.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.designPattern.dao.Shape;
import com.example.designPattern.dao.impl.Rectangle;
import com.example.designPattern.dao.impl.Square;

@Component
public class ShapeFactory {
		@Autowired
		private Rectangle rec;
		
		@Autowired
		private Square sqr;
	
	   //use getShape method to get object of type shape 
	   public Shape getShape(String shapeType){
		   
		   
	      if(shapeType == null){
	         return null;
	      }		
	       else if(shapeType.equalsIgnoreCase("REC")){
	         return rec;
	         
	      } else if(shapeType.equalsIgnoreCase("SQR")){
	         return sqr;
	      }
	      
	      return null;
	   }
	}

package com.example.kyclck.models;

public class Products {
	private String id;
	private String name;
	
	public Products() {
		
		
	}
	
	public Products(String id , String name) {
		this.id = id;
		this.name = name;		
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String name) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	

}

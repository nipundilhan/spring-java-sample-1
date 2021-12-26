package com.simplejar;

public class Student {
	
	public String name;
	public int age;
	
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String work(String subject) {
		System.out.println("student is going to start the work ");
		return " student is working on "+ subject;
	}
	
	

}

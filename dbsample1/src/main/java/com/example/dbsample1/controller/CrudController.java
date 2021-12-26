package com.example.dbsample1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbsample1.entity.course;
import com.example.dbsample1.entity.highschool;
import com.example.dbsample1.service.CrudServiceImpl;



@RestController
@RequestMapping("/test1")
public class CrudController {
	
	@Autowired 
	private CrudServiceImpl crudServiceImpl;

	@PostMapping("/save-course")
	public String addCourseList(@RequestBody List<course> listcourse) {
		for(course crs :listcourse) {
			System.out.println("id value "+ crs.getId() + " course name "+ crs.getCoursename() );
		}
		
		return crudServiceImpl.addCourseList(listcourse);
		//return "success";
	}
	
	@PostMapping("/save-school")
	public String addSchoolList(@RequestBody 	List<highschool> listschool) {
		return crudServiceImpl.addSchoolList(listschool);
	}
	
	@GetMapping("/schools")
	public Iterable<highschool> getSchools() {
		return crudServiceImpl.getSchools();
	}

}

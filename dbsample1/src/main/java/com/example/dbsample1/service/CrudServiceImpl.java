package com.example.dbsample1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbsample1.entity.course;
import com.example.dbsample1.entity.highschool;
import com.example.dbsample1.repository.courseRepository;
import com.example.dbsample1.repository.highschoolRespository;

@Service
public class CrudServiceImpl {
	
	@Autowired
	private courseRepository courseRep;
	
	@Autowired
	private highschoolRespository schoolRep;
	
	public String addCourseList(List<course> listcourse) {
		courseRep.saveAll(listcourse);
		return "success";
	}
	
	public String addSchoolList(List<highschool> listschool) {
		schoolRep.saveAll(listschool);
		return "success";
	}
	
	public Iterable<highschool> getSchools() {
	   Iterable<highschool> findAll = schoolRep.findAll();
	   return findAll;
	}

}

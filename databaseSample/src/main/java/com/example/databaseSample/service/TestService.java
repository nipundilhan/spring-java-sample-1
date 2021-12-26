package com.example.databaseSample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.databaseSample.dao.TestDao;
import com.example.databaseSample.entity.student;
import com.example.databaseSample.repository.studentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@Service
public class TestService {
	
	@Autowired
	private TestDao testDao;
	
	@Autowired
	private studentRepository studentRepo;
	
	public List<student> getDetails() {
		List<student> listStudents = testDao.getDetails();
		testDao.getMultipleTables(null, null, "Bio");
		return listStudents;
	}
	
	
	public Page<student>   getPagination() {
		//page number , page size
		Pageable pageable = PageRequest.of(0, 2);
		 
		 
		Page<student> multipleTablesPagination = testDao.getMultipleTablesPagination(null, pageable);
		return multipleTablesPagination;
	}

}

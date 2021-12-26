package com.example.dbsample1.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dbsample1.entity.student;


@Repository
@Scope("request")
public interface studentRepository  extends CrudRepository<student, Integer> {
	
	List<student> findAll();

}

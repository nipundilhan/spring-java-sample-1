package com.example.databaseSample.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.databaseSample.entity.vstdcrse;

@Repository
public interface vstdcrseRepository   extends CrudRepository<vstdcrse, Integer> {
	
	List<vstdcrse> findAll();

}

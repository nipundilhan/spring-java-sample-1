package com.example.dbsample1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dbsample1.entity.course;

@Repository
public interface courseRepository   extends CrudRepository<course, Integer> {

}

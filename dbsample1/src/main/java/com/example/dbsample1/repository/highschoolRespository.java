package com.example.dbsample1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dbsample1.entity.course;
import com.example.dbsample1.entity.highschool;

@Repository
public interface highschoolRespository   extends CrudRepository<highschool, Integer> {


}

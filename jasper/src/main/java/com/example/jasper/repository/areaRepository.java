package com.example.jasper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jasper.entity.area;
import com.example.jasper.entity.orderc;

@Repository
public interface areaRepository   extends JpaRepository<area, Integer> {

}

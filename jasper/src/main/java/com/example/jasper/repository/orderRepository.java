package com.example.jasper.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jasper.entity.customer;
import com.example.jasper.entity.orderc;

@Repository
public interface orderRepository    extends JpaRepository<orderc, Integer> {
	
	
	  @Query("SELECT c FROM orderc c WHERE c.month =:mon and c.year =:yr ")
	  List<orderc> findByYearMonth( @Param("mon") int mon ,  @Param("yr") int yr);
	  
	  @Query("SELECT SUM(c.amount) FROM orderc c WHERE c.month =:mon and c.year =:yr ")
	  int findTotalAmountByYearMonth( @Param("mon") int mon ,  @Param("yr") int yr);

}

package com.example.jasper.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jasper.entity.customer;

@Repository
public interface customerRepository   extends JpaRepository<customer, Integer> {
	
	List<customer> findAll();

	
	  @Query("SELECT c FROM customer c WHERE c.contactno =:con")
	  Optional<customer> findByContactNumber( @Param("con") Integer con);
}

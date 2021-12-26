package com.example.databaseSample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.databaseSample.dto.CustomResp1;
import com.example.databaseSample.entity.student;

@Repository
public interface studentRepository  extends CrudRepository<student, Integer> {
	
	List<student> findAll();
	
	@Query("SELECT new com.example.databaseSample.dto.CustomResp1(s.firstname,crse.coursename) from  student s join s.studentcources sc join sc.crs crse where crse.coursename = 'IT' ")
	List<CustomResp1> getJoinInformations();
	
	@Query("SELECT s from student s join s.studentcources sc join sc.crs crse where crse.coursename = 'IT' ")
	List<student> getStudentWithCourseStudentId();
	
	@Query(   " SELECT s from student s "
            + " WHERE  (:frsNm is null or s.firstname =:frsNm) "
            + " 	AND (:lstNm is null or s.lastname =:lstNm) "
            + " 	AND (:cntct is null or s.contactvalue =:cntct) ")
	List<student> getStudentDynamicCondition(@Param("frsNm") String frsNm,
            @Param("lstNm") String lstNm,@Param("cntct") String cntct);
	
	
	

}
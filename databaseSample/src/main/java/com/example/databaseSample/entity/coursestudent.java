package com.example.databaseSample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class coursestudent {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;
	  
	  @ManyToOne
	  @JoinColumn(name = "studentid")
	  private student stdnt;
	  
	  @ManyToOne
	  @JoinColumn(name = "courseid")
	  private course crs;

}

package com.example.databaseSample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class vstdcrse {
	
	@Id
	private Integer primaryid;
	
	private String studentname;
	
	private String schoolname;

	private String coursename;

	public Integer getPrimaryid() {
		return primaryid;
	}

	public void setPrimaryid(Integer primaryid) {
		this.primaryid = primaryid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	
	
}

package com.example.databaseSample.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String coursename;

	@OneToMany
	@JoinColumn(name = "courseid") // we need to duplicate the physical information
	private List<coursestudent> coursetudents;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public List<coursestudent> getCoursetudents() {
		return coursetudents;
	}

	public void setCoursetudents(List<coursestudent> coursetudents) {
		this.coursetudents = coursetudents;
	}

}

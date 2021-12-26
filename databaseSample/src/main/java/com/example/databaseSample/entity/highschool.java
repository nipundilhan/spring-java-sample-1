package com.example.databaseSample.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class highschool {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String schoolname;

	@OneToMany
	@JoinColumn(name = "highschoolid") // we need to duplicate the physical information
	private List<student> students;

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<student> getStudents() {
		return students;
	}

	public void setStudents(List<student> students) {
		this.students = students;
	}

}

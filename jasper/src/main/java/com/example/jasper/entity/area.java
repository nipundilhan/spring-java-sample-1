package com.example.jasper.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class area {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer areaid;
	  
	  private String areaname;
	  
		@OneToMany
		@JoinColumn(name = "areaid") // we need to duplicate the physical information
		private List<customer> customers;

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

}

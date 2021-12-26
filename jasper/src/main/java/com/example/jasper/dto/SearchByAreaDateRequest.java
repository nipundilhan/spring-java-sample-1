package com.example.jasper.dto;

import java.util.Date;

public class SearchByAreaDateRequest {
	

	public int getAreaid() {
		return areaid;
	}


	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	private int areaid;
	

	private Date date;

}

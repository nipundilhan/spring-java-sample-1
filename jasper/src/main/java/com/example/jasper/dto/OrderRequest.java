package com.example.jasper.dto;

import java.util.Date;

public class OrderRequest {
	
	private Integer mobileno;
	private Integer otp;
	private Integer amount;
	private Date date;
	

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getMobileno() {
		return mobileno;
	}
	public void setMobileno(Integer mobileno) {
		this.mobileno = mobileno;
	}
	public Integer getOtp() {
		return otp;
	}
	public void setOtp(Integer otp) {
		this.otp = otp;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}


}

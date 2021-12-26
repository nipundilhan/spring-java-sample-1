package com.example.jasper.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class orderc {
	
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer orderid;
	  
	  private Integer amount;
	  
	  private Integer year;
	  
	  private Integer month;
		  

		  
	private Date orderdate;
	
	  @ManyToOne
	  @JoinColumn(name = "customerid")
	  private customer cus;
	
	  public customer getCus() {
		return cus;
	}



	public void setCus(customer cus) {
		this.cus = cus;
	}



	public Integer getOrderid() {
		return orderid;
	}



	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}



	public Integer getAmount() {
		return amount;
	}



	public void setAmount(Integer amount) {
		this.amount = amount;
	}



	public Date getOrderdate() {
		return orderdate;
	}



	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}





}

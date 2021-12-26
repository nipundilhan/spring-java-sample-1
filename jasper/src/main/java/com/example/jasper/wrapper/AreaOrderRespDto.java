package com.example.jasper.wrapper;



import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonProperty;



@SqlResultSetMapping(name = "AreaOrderRespDtoMapping", entities = {
		@EntityResult(entityClass = AreaOrderRespDto.class, fields = {
 				@FieldResult(name = "orderid", column = "orderid"), 
				@FieldResult(name = "namecustomer", column = "namecustomer"),
				@FieldResult(name = "contactno", column = "contactno"),
				@FieldResult(name = "address", column = "address"),
				@FieldResult(name = "amount", column = "amount"),
				@FieldResult(name = "totalprice", column = "totalprice") }), })



@Entity
public class AreaOrderRespDto {
	
	@Id
	private int orderid;
	

	private String namecustomer;
	

	private String contactno;
	

	private String address;
		
	
	private int amount;
	
	private String totalprice;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getNamecustomer() {
		return namecustomer;
	}

	public void setNamecustomer(String namecustomer) {
		this.namecustomer = namecustomer;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	
	
	
	

}


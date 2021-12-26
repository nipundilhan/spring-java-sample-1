package com.example.jasper.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class customer {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;

	  private Integer contactno;
	  
	  private String name;

	  private String address;
	  
	  private Integer otp;
	  
		@OneToMany
		@JoinColumn(name = "customerid") // we need to duplicate the physical information
		private List<orderc> orders;
		
		  private String email;

	public List<orderc> getOrders() {
			return orders;
		}

		public void setOrders(List<orderc> orders) {
			this.orders = orders;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContactno() {
		return contactno;
	}

	public void setContactno(Integer contactno) {
		this.contactno = contactno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

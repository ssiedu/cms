package com.ssi;

public class Customer {
	private String email;
	private String password;
	private String cname;
	private String address;
	private String mobile;
	
	public Customer() {
		
	}
	public Customer(String email, String password, String cname,
			String address, String mobile) {
		super();
		this.email = email;
		this.password = password;
		this.cname = cname;
		this.address = address;
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}

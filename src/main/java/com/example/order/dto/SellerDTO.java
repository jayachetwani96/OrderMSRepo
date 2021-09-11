package com.example.order.dto;

public class SellerDTO {
	
	Integer sellerId;
	String name;
	String email;
	long phoneNo;
	String password;
	boolean isActive;
	
	
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "SellerDTO [sellerId=" + sellerId + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", password=" + password + ", isActive=" + isActive + "]";
	}
	
	

}

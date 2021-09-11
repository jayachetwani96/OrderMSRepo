package com.example.order.dto;

public class BuyerDTO {
	Integer buyerId;
	String name;
	String email;
	long phoneNo;
	String password;
	boolean isPrivileged;
	int rewardPoints;
	boolean isActive;
	
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
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
	public boolean isPrivileged() {
		return isPrivileged;
	}
	public void setPrivileged(boolean isPrivileged) {
		this.isPrivileged = isPrivileged;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "BuyerDTO [buyerId=" + buyerId + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", password=" + password + ", isPrivileged=" + isPrivileged + ", rewardPoints=" + rewardPoints
				+ ", isActive=" + isActive + "]";
	}
	
	
}

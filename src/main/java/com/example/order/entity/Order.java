package com.example.order.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ordertable")
public class Order {
	
	@Id
	@Column(name="orderid", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer orderId;
	
	@Column(name="buyerid", nullable = false)
	Integer buyerId;
	
	@Column(name="amount",nullable = false)
	long amount;
	
	@Column(name="dateoforder",nullable = false)
	LocalDateTime dateOfOrder;

	@Column(name="address",nullable = false)
	String address;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="status",nullable = false)
	StatusValues statusValue;
	
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public StatusValues getStatus() {
		return statusValue;
	}
	public void setStatus(StatusValues status) {
		this.statusValue = status;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public LocalDateTime getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(LocalDateTime dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Order() {
		super();
	}
	
	
}

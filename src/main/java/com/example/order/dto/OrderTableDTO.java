package com.example.order.dto;

import java.time.LocalDateTime;


import com.example.order.entity.Order;
import com.example.order.entity.StatusValues;

public class OrderTableDTO {
	Integer orderId;
	Integer buyer;
	long amount;
	LocalDateTime dateOfOrder;
	String address;
	String Status;
	StatusValues statusValue;
	//CartDTO cart;
	
	
	
	public Integer getOrderId() {
		return orderId;
	}
	public StatusValues getStatusValue() {
		return statusValue;
	}
	public void setStatusValue(StatusValues statusValue) {
		this.statusValue = statusValue;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Integer getBuyer() {
		return buyer;
	}
	public void setBuyer(Integer buyer) {
		this.buyer = buyer;
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
	
	@Override
	public String toString() {
		return "OrderTableDTO [orderId=" + orderId + ", buyer=" + buyer + ", amount=" + amount + ", dateOfOrder="
				+ dateOfOrder + ", address=" + address + "]";
	}
	
	
	public static OrderTableDTO valueOf(Order order)
	{
		OrderTableDTO orderdto = new OrderTableDTO();
		orderdto.setOrderId(order.getOrderId());
		orderdto.setAddress(order.getAddress());
		orderdto.setAmount(order.getAmount());
		orderdto.setDateOfOrder(order.getDateOfOrder());
		//BuyerDTO buyerdto =new BuyerDTO();
		orderdto.setBuyer(order.getBuyerId());
		//orderdto.setBuyer(buyerdto);
		switch(order.getStatus()) {
		case orderPlaced:
			orderdto.setStatus("Order Placed");
			break;
		case orderCancelled:
			orderdto.setStatus("Order Cancel");
			break;
		}
		return orderdto;
	}

	public Order CreateEntity()
	{
		//this.cart = cart;
		Order order = new Order();
		//order.setOrderId(this.getOrderId());
		order.setAddress(this.getAddress());
		order.setAmount(this.getAmount());
		order.setDateOfOrder(LocalDateTime.now());
		order.setStatus(StatusValues.orderPlaced);
		order.setBuyerId(this.getBuyer());
		return order;
	}
	
}

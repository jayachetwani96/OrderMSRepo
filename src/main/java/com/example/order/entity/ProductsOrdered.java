package com.example.order.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@IdClass(KeyComp.class)
@Table(name="productsordered")
public class ProductsOrdered {
	
	@Column(name="buyerid", nullable = false)
	@Id
	Integer buyerId;
	
	@Column(name= "sellerid", nullable = false)
	Integer sellerId;
	
	@Column(name="prodid",nullable = false)
	@Id
	Integer prodId;
	
	@Column(name="quantity",nullable = false)
	int quantity;

	

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductsOrdered() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}


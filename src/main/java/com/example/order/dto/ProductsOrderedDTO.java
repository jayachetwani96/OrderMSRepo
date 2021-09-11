package com.example.order.dto;

import com.example.order.entity.ProductsOrdered;

public class ProductsOrderedDTO {
	
	BuyerDTO buyer; 
	ProductDTO prod;
	SellerDTO seller;
	int Quantity;
	
	public BuyerDTO getBuyer() {
		return buyer;
	}
	public void setBuyer(BuyerDTO buyer) {
		this.buyer = buyer;
	}
	public ProductDTO getProd() {
		return prod;
	}
	public void setProd(ProductDTO prod) {
		this.prod = prod;
	}
	public SellerDTO getSeller() {
		return seller;
	}
	public void setSeller(SellerDTO seller) {
		this.seller = seller;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "ProductsOrderedDTO [buyer=" + buyer + ", prod=" + prod + ", seller=" + seller + ", Quantity=" + Quantity
				+ "]";
	}
	
	
	public static ProductsOrderedDTO valueOf(ProductsOrdered productsOrder)
	{
		ProductsOrderedDTO productdto =new ProductsOrderedDTO();
		
		BuyerDTO buyer = new BuyerDTO();
		buyer.setBuyerId(productsOrder.getBuyerId());
		ProductDTO product= new ProductDTO();
		product.setProdId(productsOrder.getProdId());
		SellerDTO seller = new SellerDTO();
		seller.setSellerId(productsOrder.getSellerId());

		productdto.setBuyer(buyer);
		productdto.setProd(product);
		productdto.setSeller(seller);
		productdto.setQuantity(productsOrder.getQuantity());
		
		return productdto;
	}
	
	public ProductsOrdered CreateEntity() {
		ProductsOrdered productsOrdered = new ProductsOrdered();
		productsOrdered.setBuyerId(this.getBuyer().getBuyerId());
		productsOrdered.setProdId(this.getProd().getProdId());
		productsOrdered.setSellerId(this.getBuyer().getBuyerId());
		productsOrdered.setQuantity(this.getQuantity());
		return productsOrdered;
	}
}

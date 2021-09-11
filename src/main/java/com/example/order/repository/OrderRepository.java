package com.example.order.repository;

import java.util.List;
import com.example.order.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface OrderRepository extends JpaRepository<Order,Integer>{
	List<Order> findAll();
	
	Order findByOrderId(Integer orderId);
	
	@Query("SELECT o FROM Order o WHERE o.orderId = ?1 and o.buyerId = ?2")
	Order findByOrderIdAndBuyerId(Integer orderId,Integer buyerId);
}
package com.example.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order.entity.ProductsOrdered;

public interface ProductsOrderRepo extends JpaRepository<ProductsOrdered, Integer> {

}

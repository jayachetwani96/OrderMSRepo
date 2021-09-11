package com.example.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//@EnableJpaAuditing
//@EntityScan(basePackages="com.example.order")
@SpringBootApplication
public class OrderMsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderMsApplication.class, args);
	}
}
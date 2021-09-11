package com.example.order.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order.dto.OrderTableDTO;
import com.example.order.entity.Order;
import com.example.order.entity.StatusValues;
import com.example.order.exception.OrderException;
import com.example.order.repository.OrderRepository;
import com.example.order.repository.ProductsOrderRepo;


@Service
public class OrderService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ProductsOrderRepo productOrderRepo;
	
	public List<OrderTableDTO> getAllOrders() throws OrderException {
		List<Order> orders = orderRepo.findAll();
		List<OrderTableDTO> orderDtos = new ArrayList<OrderTableDTO>();
		for (Order order : orders) {
			OrderTableDTO orderDto = OrderTableDTO.valueOf(order);
			orderDtos.add(orderDto);
			logger.info("order details : {}", order.getStatus());
		}
		if(orderDtos.isEmpty())
			throw new OrderException("Service.ORDERS_NOT_FOUND");
		
		logger.info("order details : {}", orders);
		return orderDtos;
	}
	
	
	
	public String makeOrder(OrderTableDTO orderDTO)throws OrderException
	{
					
		logger.info("Creation request to make an order {}", orderDTO);
		Order order = orderDTO.CreateEntity();
//		if(order.getAmount()>299) {
//			throw new OrderException("General.EXCEPTION_MESSAGE");
//		}
		orderRepo.save(order);
		return "Order Placed Successfully";
	}
	
	
	public String reOrder(Integer orderId, Integer buyerId) throws OrderException {
		OrderTableDTO orderTableDTO = OrderTableDTO.valueOf(orderRepo.findByOrderIdAndBuyerId(orderId, buyerId));
		logger.info("Creation request to make an order {}", orderTableDTO);
		Order order = orderTableDTO.CreateEntity();
		logger.info("Creation request to make an order {}", order);
		order.setStatus(StatusValues.reOrder);
		orderRepo.save(order);
		return "Reorder is Successful";
	}
	
	
	
	public OrderTableDTO getSpecificOrder(Integer orderId)throws OrderException{
		Order optional = orderRepo.findByOrderId(orderId);
		//optional.orElseThrow(() -> new OrderException("Service.ORDER_NOT_FOUND"));
		if(optional == null)
		{
			throw new OrderException("Service.ORDER_NOT_FOUND");
		}
		
		logger.info("order details : {}", orderId);
		return OrderTableDTO.valueOf(orderRepo.findByOrderId(orderId));
	}
}

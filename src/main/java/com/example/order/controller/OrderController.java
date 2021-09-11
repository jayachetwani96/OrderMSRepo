package com.example.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import com.example.order.dto.OrderTableDTO;
import com.example.order.exception.OrderException;
import com.example.order.service.OrderService;


@RestController
@RequestMapping
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderService orderService;
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	Environment environment;
	
	@Bean
	RestTemplate bean() {
		return new RestTemplate();
	}
	
//	public OrderController(RestTemplateBuilder restTemp){
//		template=restTemp.build();
//	}
	
	
	@GetMapping(value="/orders", produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<List<OrderTableDTO>> getAllOrders() throws OrderException{
	logger.info("Fetching all Orders");
	return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/orders/placeOrder",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> makeOrder(@RequestBody OrderTableDTO orderDTO) throws OrderException
	{
		//CartDTO cart= template.getForObject("http://localhost:8300/Cart"+"/orders/"+orderDTO.getBuyer(), CartDTO.class);
		//logger.info("Cart"+ cart.getQuantity());
		//ProductDTO product= template.getForObject("http://localhost:8300/Cart"+"/orders/"+orderDTO.getBuyer(), CartDTO.class);
		//logger.info("Cart"+ cart.getQuantity());
		logger.info("Creation request for customer {}", orderDTO);
		String message = orderService.makeOrder(orderDTO);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	
	@PostMapping(value = "/orders/reOrder/{orderId}/{buyerId}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> reOrder(@PathVariable Integer orderId,@PathVariable Integer buyerId) throws OrderException
	{
		logger.info("Creation request for customer {}");
		String message = orderService.reOrder(orderId,buyerId);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/orders/{orderId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderTableDTO> getSpecificOrders(@PathVariable Integer orderId) throws OrderException {
		try {
			logger.info("Fetching details of order {}",orderId);
			return new ResponseEntity<>(orderService.getSpecificOrder(orderId),HttpStatus.OK);
		}
		catch(OrderException orderException) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(orderException.getMessage()),orderException);
		}
		
	}
	
	
	
}

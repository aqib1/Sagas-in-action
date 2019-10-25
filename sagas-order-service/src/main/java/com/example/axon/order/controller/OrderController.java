package com.example.axon.order.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.axon.order.dto.OrderCreateDto;
import com.example.axon.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
	        this.orderService = orderService;
	    }

	@PostMapping
	public CompletableFuture<String> createOrder(@RequestBody OrderCreateDto orderCreateDTO) {
		return orderService.creatOrder(orderCreateDTO);
	}
}

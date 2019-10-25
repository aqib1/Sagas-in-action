package com.example.axon.order.service;

import java.util.concurrent.CompletableFuture;

import com.example.axon.order.dto.OrderCreateDto;

public interface OrderService {

	public CompletableFuture<String> creatOrder(OrderCreateDto dto);
}

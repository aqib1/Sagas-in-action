package com.example.axon.order.service.Impl;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;

import com.example.axon.models.commands.CreateOrderCommand;
import com.example.axon.order.aggregates.OrderStatus;
import com.example.axon.order.dto.OrderCreateDto;
import com.example.axon.order.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private final CommandGateway commandGateway;

	public OrderServiceImpl(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@Override
	public CompletableFuture<String> creatOrder(OrderCreateDto dto) {
		return commandGateway.send(new CreateOrderCommand(UUID.randomUUID().toString(), dto.getItemType(),
				dto.getPrice(), dto.getCurrency(), String.valueOf(OrderStatus.CREATED)));
	}

}

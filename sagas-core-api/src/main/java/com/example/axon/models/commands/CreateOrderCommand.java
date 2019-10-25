package com.example.axon.models.commands;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateOrderCommand {
	@TargetAggregateIdentifier
	private String orderId;
	
	private final String itemType;

	private final BigDecimal price;

	private final String currency;

	private final String orderStatus;

	public CreateOrderCommand(String orderId, String itemType, BigDecimal price, String currency, String orderStatus) {
		this.orderId = orderId;
		this.itemType = itemType;
		this.price = price;
		this.currency = currency;
		this.orderStatus = orderStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getItemType() {
		return itemType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getCurrency() {
		return currency;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

}

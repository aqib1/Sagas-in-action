package com.example.axon.models.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateShippingCommand {

	@TargetAggregateIdentifier
	private String shippingId;

	private String orderId;

	private String paymentId;

	public CreateShippingCommand(String shippingId, String orderId, String paymentId) {
		this.shippingId = shippingId;
		this.orderId = orderId;
		this.paymentId = paymentId;
	}

	public CreateShippingCommand() {

	}

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

}

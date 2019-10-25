package com.example.axon.models.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateInvoiceCommand {

	@TargetAggregateIdentifier
	private final String paymentId;

	private final String orderId;

	public CreateInvoiceCommand(String paymentId, String orderId) {
		this.paymentId = paymentId;
		this.orderId = orderId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public String getOrderId() {
		return orderId;
	}
}

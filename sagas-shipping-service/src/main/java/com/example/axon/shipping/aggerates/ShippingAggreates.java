package com.example.axon.shipping.aggerates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.axon.models.commands.CreateShippingCommand;
import com.example.axon.models.events.OrderShippingEvent;

@Aggregate
public class ShippingAggreates {

	@AggregateIdentifier
	private String shippingId;
	
	private String orderId;
	
	private String paymentId;
	
	
	public ShippingAggreates() {
		
	}


	public ShippingAggreates(String shippingId, String orderId, String paymentId) {
		super();
		this.shippingId = shippingId;
		this.orderId = orderId;
		this.paymentId = paymentId;
	}

	@CommandHandler
	public ShippingAggreates(CreateShippingCommand createShippingCommand) {
		AggregateLifecycle.apply(new OrderShippingEvent(createShippingCommand.getShippingId(), createShippingCommand.getOrderId(), createShippingCommand.getPaymentId()));
	}

	@EventSourcingHandler
	protected void on(OrderShippingEvent event) {
		this.orderId = event.getOrderId();
		this.paymentId = event.getPaymentId();
		this.shippingId = event.getShippingId();
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

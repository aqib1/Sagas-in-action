package com.example.axon.order.aggregates;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.axon.models.commands.CreateOrderCommand;
import com.example.axon.models.events.CreateOrderEvent;

@Aggregate
public class OrderAggregate {

	private String orderId;
	
	private ItemType itemType;
	
	private BigDecimal price;
	
	private String currency;
	
	private OrderStatus orderStatus;
	
	public OrderAggregate() {
		
	}
	
	@CommandHandler
	public OrderAggregate(CreateOrderCommand createOrderCommand) {
		AggregateLifecycle.apply(new CreateOrderEvent(createOrderCommand.getOrderId(), createOrderCommand.getItemType(), createOrderCommand.getPrice(), createOrderCommand.getCurrency(), createOrderCommand.getOrderStatus()));
	}
	
	@EventSourcingHandler
	public void on(CreateOrderEvent event) {
		this.orderId = event.getOrderId();
		this.currency = event.getCurrency();
		this.itemType = ItemType.valueOf(event.getItemType());
		this.orderStatus = OrderStatus.valueOf(event.getOrderStatus());
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
}

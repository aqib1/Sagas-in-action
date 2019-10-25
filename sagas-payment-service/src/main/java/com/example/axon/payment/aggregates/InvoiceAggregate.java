package com.example.axon.payment.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.axon.models.commands.CreateInvoiceCommand;
import com.example.axon.models.events.CreateInvoiceEvent;

@Aggregate
public class InvoiceAggregate {

	@AggregateIdentifier
	private String paymentId;

	private String orderId;

	private InvoiceStatus invoiceStatus;

	public InvoiceAggregate() {

	}

	@CommandHandler
	public InvoiceAggregate(CreateInvoiceCommand invoiceCommand) {
		AggregateLifecycle.apply(new CreateInvoiceEvent(invoiceCommand.getPaymentId(), invoiceCommand.getOrderId()));
	}

	@EventSourcingHandler
	protected void on(CreateInvoiceEvent e) {
		this.paymentId = e.getPaymentId();
		this.orderId = e.getOrderId();
		this.invoiceStatus = InvoiceStatus.PAID;		
	}
	
	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public InvoiceStatus getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

}

package com.example.axon.models.events;

public class CreateInvoiceEvent {

	private String paymentId;
	
	private String orderId;
	
	public CreateInvoiceEvent() {
		
	}
	
	public CreateInvoiceEvent(String paymentID, String orderId) {
		this.paymentId = paymentID;
		this.orderId = orderId;
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
	
	
}

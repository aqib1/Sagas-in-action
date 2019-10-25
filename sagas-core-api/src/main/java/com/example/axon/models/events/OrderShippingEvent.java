package com.example.axon.models.events;

public class OrderShippingEvent {
	
	private String shippingId;

	private String orderId;

	private String paymentId;

	public OrderShippingEvent(String shippingId, String orderId, String paymentId) {
        this.shippingId = shippingId;
        this.orderId = orderId;
        this.paymentId = paymentId;
    }

	public String getShippingId() {
		return shippingId;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getPaymentId() {
		return paymentId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}
}

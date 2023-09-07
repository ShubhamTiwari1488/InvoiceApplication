package com.highradius.actions;

import java.util.List;

import com.highradius.manager.OrderDetailsManager;
import com.highradius.managerimpl.OrderDetailsManagerImpl;
import com.highradius.pojo.OrderDetails;

public class OrderDetailsAction {
	private OrderDetails orderDetails;
	private List<OrderDetails> orderDetail;

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	

	public List<OrderDetails> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetails> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public String insertOrderDetails() {
		String s = "ERROR";
		OrderDetailsManager orderDetailsManager = new OrderDetailsManagerImpl();
		int result = orderDetailsManager.insertOrderDetails(orderDetails);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;
	}
	public String readOrderDetailsById() {
		String s = "ERROR";
		OrderDetailsManager orderDetailsManager = new OrderDetailsManagerImpl();
		orderDetails = orderDetailsManager.readOrderDetailsById(orderDetails);
		if(orderDetails != null) {
			s = "SUCCESS";
		}
		return s;
	}
	public String readOrderDetailsByIds() {
		String s = "ERROR";
		OrderDetailsManager orderDetailsManager = new OrderDetailsManagerImpl();
		orderDetail = orderDetailsManager.readOrderDetailsByIds(orderDetail);
		if(orderDetail != null) {
			s = "SUCCESS";
		}
		return s;
	}
	public String deleteOrderDetailsById() {
		String s = "ERROR";
		OrderDetailsManager orderDetailsManager = new OrderDetailsManagerImpl();
		int result = orderDetailsManager.deleteOrderDetailsById(orderDetails);
		if(result > 0) {
			s = "SUCCESS";
		}
		return s;
	}
	public String deleteOrderDetailsByIds() {
		String s = "ERROR";
		OrderDetailsManager orderDetailsManager = new OrderDetailsManagerImpl();
		int result = orderDetailsManager.deleteOrderDetailsByIds(orderDetail);
		if(result > 0) {
			s = "SUCCESS";
		}
		return s;
	}
	public String updateOrderDetailsById() {
		String s = "ERROR";
		OrderDetailsManager orderDetailsManager = new OrderDetailsManagerImpl();
		int result = orderDetailsManager.updateOrderDetailsById(orderDetails);
		if(result > 0) {
			s = "SUCCESS";
		}
		return s;
	}
	
	public String updateOrderDetailsByProductId() {
		String s = "ERROR";
		OrderDetailsManager orderDetailsManager = new OrderDetailsManagerImpl();
		int result = orderDetailsManager.updateOrderDetailsByProductId(orderDetails);
		if(result > 0) {
			s = "SUCCESS";
		}
		return s;
	}
	
	public String updateOrderDetailsByOrderId() {
		String s = "ERROR";
		OrderDetailsManager orderDetailsManager = new OrderDetailsManagerImpl();
		int result = orderDetailsManager.updateOrderDetailsByOrderId(orderDetails);
		if(result > 0) {
			s = "SUCCESS";
		}
		return s;
	}
	

}

package com.highradius.actions;

import java.util.List;

import com.highradius.manager.OrderManager;
import com.highradius.managerimpl.OrderManagerImpl;
import com.highradius.pojo.Customer;
import com.highradius.pojo.Employee;
import com.highradius.pojo.Orders;

public class OrdersAction {
	private Orders order;
	private List<Orders> orders;

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public String insertOrder() {
		String s = "ERROR";
		OrderManager orderManager = new OrderManagerImpl();
		int result = orderManager.insertOrder(order);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;
	}

	public String insertOrders() {
		String s = "ERROR";
		OrderManager orderManager = new OrderManagerImpl();
		int result = orderManager.insertOrders(orders);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;
	}

	public String readAllOrders() {
		String s = "ERROR";

		OrderManager orderManager = new OrderManagerImpl();
		orders = orderManager.readAllOrders();
		if (orders != null) {
			s = "SUCCESS";
		}
		return s;
	}

	private int orderID;

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String readOrderByOrderId() {
		String s = "ERROR";
		OrderManager orderManager = new OrderManagerImpl();
		order = orderManager.getOrderById(orderID);
		if (order != null) {
			s = "SUCCESS";
		}
		return s;
	}

	private int customerID;

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String readOrderByCustomerId() {
		String s = "ERROR";
		OrderManager orderManager = new OrderManagerImpl();
		orders = orderManager.getOrderByCustomerId(customerID);
		if (orders != null) {
			s = "SUCCESS";
		}
		return s;
	}

	private String orderDate;

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String readOrderByOrderDate() {
		String s = "ERROR";
		OrderManager orderManager = new OrderManagerImpl();
		orders = orderManager.getOrderByOrderDate(orderDate);
		if (orders != null) {
			s = "SUCCESS";
		}
		return s;
	}

	private int employeeID;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String readOrderByEmployeeId() {
		String s = "ERROR";
		OrderManager orderManager = new OrderManagerImpl();
		orders = orderManager.getOrderByEmployeeId(employeeID);
		if (orders != null) {
			s = "SUCCESS";
		}
		return s;
	}

	private int orderIdForUpdate;
	private Customer customer;
	private Employee employee;

	public int getOrderIdForUpdate() {
		return orderIdForUpdate;
	}

	public void setOrderIdForUpdate(int orderIdForUpdate) {
		this.orderIdForUpdate = orderIdForUpdate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String updateByOrderId() {
		String s = "ERROR";
		OrderManager orderManager = new OrderManagerImpl();
		int result = orderManager.updateByOrderId(orderIdForUpdate, customer, employee);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;
	}

	public String updateByShipperId() {
		String s = "ERROR";
		OrderManager orderManager = new OrderManagerImpl();
		int result = orderManager.updateByShipperId(order, customer, employee);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;
	}

	public String deleteByOrderId() {
		String s = "ERROR";
		OrderManager orderManager = new OrderManagerImpl();
		int result = orderManager.deleteByOrderId(order);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;
	}

	public String deleteOrderByEmpId() {
		String s = "ERROR";
		OrderManager orderManager = new OrderManagerImpl();
		int result = orderManager.deleteByEmpId(order);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;

	}
	
	public String deleteOrderByCustId() {
		String s = "ERROR";
		OrderManager orderManager = new OrderManagerImpl();
		int result = orderManager.deleteByCustomerId(order);
		if(result > 0) {
			s = "SUCCESS";
		}
		return s;
	}

}

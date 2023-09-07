package com.highradius.manager;

import java.util.List;

import com.highradius.pojo.Customer;
import com.highradius.pojo.Employee;
import com.highradius.pojo.Orders;

public interface OrderManager {
	int insertOrder(Orders order);
	int insertOrders(List<Orders> orders);
	List<Orders> readAllOrders();
	Orders getOrderById(int orderId);
	List<Orders> getOrderByCustomerId(int customerID);
	List<Orders> getOrderByOrderDate(String orderDate);
	List<Orders> getOrderByEmployeeId(int employeeId);
	int updateByOrderId(int orderIdForUpdate, Customer customer, Employee employee);
	int updateByShipperId(Orders order,Customer customer,Employee employee);
	int deleteByOrderId(Orders order);
	int deleteByEmpId(Orders order);
	int deleteByCustomerId(Orders order);
	
}

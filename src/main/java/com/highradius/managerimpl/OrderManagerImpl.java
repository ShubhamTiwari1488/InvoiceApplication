package com.highradius.managerimpl;

import java.util.List;

import com.highradius.dao.OrderDao;
import com.highradius.daoimpl.OrderDaoImpl;
import com.highradius.manager.OrderManager;
import com.highradius.pojo.Customer;
import com.highradius.pojo.Employee;
import com.highradius.pojo.Orders;

public class OrderManagerImpl implements OrderManager {
	private OrderDao orderDao;

	@Override
	public int insertOrder(Orders order) {

		orderDao = new OrderDaoImpl();
		return orderDao.insertOrder(order);
	}

	@Override
	public int insertOrders(List<Orders> orders) {
		orderDao = new OrderDaoImpl();
		return orderDao.insertOrders(orders);
	}

	@Override
	public List<Orders> readAllOrders() {
		orderDao = new OrderDaoImpl();
		return orderDao.readAllOrders();
	}

	@Override
	public Orders getOrderById(int orderId) {
		orderDao = new OrderDaoImpl();
		return orderDao.getOrderById(orderId);
	}

	@Override
	public List<Orders> getOrderByCustomerId(int customerID) {
		orderDao = new OrderDaoImpl();
		return orderDao.getOrderByCustomerId(customerID);
	}

	@Override
	public List<Orders> getOrderByOrderDate(String orderDate) {
		orderDao = new OrderDaoImpl();
		return orderDao.getOrderByOrderDate(orderDate);
	}

	@Override
	public List<Orders> getOrderByEmployeeId(int employeeId) {
		orderDao = new OrderDaoImpl();
		return orderDao.getOrderByEmployeeId(employeeId);

	}

	@Override
	public int updateByOrderId(int orderIdForUpdate, Customer customer, Employee employee) {
		orderDao = new OrderDaoImpl();
		return orderDao.updateByOrderId(orderIdForUpdate, customer, employee);

	}

	@Override
	public int updateByShipperId(Orders order,Customer customer,Employee employee) {
		orderDao = new OrderDaoImpl();
		return orderDao.updateByShipperId(order,customer,employee);
	}

	@Override
	public int deleteByOrderId(Orders order) {
		orderDao = new OrderDaoImpl();
		return orderDao.deleteByOrderId(order);
	}

	@Override
	public int deleteByEmpId(Orders order) {
		orderDao = new OrderDaoImpl();
		return orderDao.deleteByEmpId(order);
	}

	@Override
	public int deleteByCustomerId(Orders order) {
		orderDao = new OrderDaoImpl();
		return orderDao.deleteByCustomerId(order);
	}

	

}

package com.highradius.managerimpl;

import java.util.List;

import com.highradius.dao.OrderDetailsDao;
import com.highradius.daoimpl.OrderDetailsDaoImpl;
import com.highradius.manager.OrderDetailsManager;
import com.highradius.pojo.OrderDetails;

public class OrderDetailsManagerImpl implements OrderDetailsManager {
	private OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();

	@Override
	public int insertOrderDetails(OrderDetails orderDetails) {
		
		return orderDetailsDao.insertOrderDetails(orderDetails);

	}

	@Override
	public OrderDetails readOrderDetailsById(OrderDetails orderDetails) {
		
		return orderDetailsDao.readOrderDetailsById(orderDetails);
	}

	@Override
	public List<OrderDetails> readOrderDetailsByIds(List<OrderDetails> orderDetail) {
		
		return orderDetailsDao.readOrderDetailsByIds(orderDetail);
	}

	@Override
	public int deleteOrderDetailsById(OrderDetails orderDetails) {
		
		return orderDetailsDao.deleteOrderDetailsById(orderDetails);
	}

	@Override
	public int deleteOrderDetailsByIds(List<OrderDetails> orderDetail) {
		
		return orderDetailsDao.deleteOrderDetailsByIds(orderDetail);
	}

	@Override
	public int updateOrderDetailsById(OrderDetails orderDetails) {
		
		return orderDetailsDao.updateOrderDetailsById(orderDetails);
	}

	@Override
	public int updateOrderDetailsByProductId(OrderDetails orderDetails) {
		
		return orderDetailsDao.updateOrderDetailsByProductId(orderDetails);
	}

	@Override
	public int updateOrderDetailsByOrderId(OrderDetails orderDetails) {
		
		return orderDetailsDao.updateOrderDetailsByOrderId(orderDetails);
	}

}

package com.highradius.dao;

import java.util.List;

import com.highradius.pojo.OrderDetails;

public interface OrderDetailsDao {
	int insertOrderDetails(OrderDetails orderDetails);

	OrderDetails readOrderDetailsById(OrderDetails orderDetails);

	List<OrderDetails> readOrderDetailsByIds(List<OrderDetails> orderDetail);

	int deleteOrderDetailsById(OrderDetails orderDetails);

	int deleteOrderDetailsByIds(List<OrderDetails> orderDetail);

	int updateOrderDetailsById(OrderDetails orderDetails);

	int updateOrderDetailsByProductId(OrderDetails orderDetails);

	int updateOrderDetailsByOrderId(OrderDetails orderDetails);

}


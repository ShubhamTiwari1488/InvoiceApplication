package com.highradius.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.highradius.dao.OrderDetailsDao;
import com.highradius.hibernateutil.HibernateUtil;

import com.highradius.pojo.OrderDetails;

public class OrderDetailsDaoImpl implements OrderDetailsDao {

	@Override
	public int insertOrderDetails(OrderDetails orderDetails) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(orderDetails.getOrder().getCustomer());
			session.save(orderDetails.getOrder().getEmployee());
			session.save(orderDetails.getOrder().getShipper());
			session.save(orderDetails.getOrder());
			session.save(orderDetails.getProduct().getCategory());
			session.save(orderDetails.getProduct().getSupplier());
			session.save(orderDetails.getProduct());
			session.save(orderDetails);

			session.save(orderDetails);
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return 0;
	}

	@Override
	public OrderDetails readOrderDetailsById(OrderDetails orderDetails) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		OrderDetails allOrderDetails = null;
		try {
			Transaction transaction = session.beginTransaction();

			Criteria criteria = session.createCriteria(OrderDetails.class)
					.add(Restrictions.eq("orderDetailId", orderDetails.getOrderDetailId()));
			allOrderDetails = (OrderDetails) criteria.list().get(0);
			if (allOrderDetails != null) {
				System.out.println("Read orderDetails by orderDetailId Successfully.");
			} else {
				System.out.println("No data found for given orderDetailsId.");
			}
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return allOrderDetails;
	}

	@Override
	public List<OrderDetails> readOrderDetailsByIds(List<OrderDetails> orderDetail) {
		List<OrderDetails> allOrderDetails = new ArrayList<OrderDetails>();
		for (OrderDetails orderDetails : orderDetail) {
			allOrderDetails.add(readOrderDetailsById(orderDetails));
		}
		return allOrderDetails;
	}

	@Override
	public int deleteOrderDetailsById(OrderDetails orderDetails) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		OrderDetails allOrderDetails = null;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			allOrderDetails = (OrderDetails) session.get(OrderDetails.class, orderDetails.getOrderDetailId());
			if (allOrderDetails != null) {
				session.delete(allOrderDetails);
				System.out.println("orderDetails deleted by orderDetailId Successfully.");
			} else {
				System.out.println("No data found for given orderDetailsId.");
			}
			transaction.commit();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (transaction != null)
				transaction.rollback();
			if (session != null) {
				session.close();
			}
		}
		return 0;
	}

	@Override
	public int deleteOrderDetailsByIds(List<OrderDetails> orderDetail) {
		for (OrderDetails orderDetailsToDelete : orderDetail) {
			deleteOrderDetailsById(orderDetailsToDelete);
		}
		return 0;
	}

	@Override
	public int updateOrderDetailsById(OrderDetails orderDetails) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			OrderDetails allOrderDetails = (OrderDetails) session.get(OrderDetails.class, orderDetails.getOrderDetailId());
			if (allOrderDetails != null) {
				allOrderDetails.setQuantity(orderDetails.getQuantity());
				session.update(allOrderDetails);
				
				System.out.println("orderDetails update by orderDetailId Successfully.");

			} else {
				System.out.println("No data found for given orderDetailsId.");
			}
			transaction.commit();
			

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			
			if (session != null) {
				session.close();
			}
		}
		return 0;
	}

	@Override
	public int updateOrderDetailsByProductId(OrderDetails orderDetails) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(OrderDetails.class);
			criteria.add(Restrictions.eq("product.productId", orderDetails.getProduct().getProductId()));
			@SuppressWarnings("unchecked")
			List<OrderDetails> allOrderDetails = criteria.list();
			for (OrderDetails oD : allOrderDetails) {
				if (oD != null) {
					oD.setOrderDetailId(orderDetails.getOrderDetailId());
					oD.setOrder(orderDetails.getOrder());
					oD.setProduct(orderDetails.getProduct());
					oD.setQuantity(orderDetails.getQuantity());
					session.update(oD);
				}
			}

			if (allOrderDetails != null) {
				System.out.println("orderDetails update by productId Successfully.");
			}

			else {
				System.out.println("No data found for given productId.");
			}
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return 0;
	}

	@Override
	public int updateOrderDetailsByOrderId(OrderDetails orderDetails) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(OrderDetails.class);
			criteria.add(Restrictions.eq("order.orderId", orderDetails.getOrder().getOrderId()));
			@SuppressWarnings("unchecked")
			List<OrderDetails> allOrderDetails = criteria.list();
			for (OrderDetails oD : allOrderDetails) {
				if (oD != null) {
					oD.setOrderDetailId(orderDetails.getOrderDetailId());
					oD.setOrder(orderDetails.getOrder());
					oD.setProduct(orderDetails.getProduct());
					oD.setQuantity(orderDetails.getQuantity());
					session.update(oD);
				}
			}

			if (allOrderDetails != null) {
				System.out.println("orderDetails update by OrderId Successfully.");
			}

			else {
				System.out.println("No data found for given OrderId.");
			}
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return 0;
	}

}

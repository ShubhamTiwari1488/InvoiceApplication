package com.highradius.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.highradius.dao.OrderDao;
import com.highradius.hibernateutil.HibernateUtil;
import com.highradius.pojo.Customer;
import com.highradius.pojo.Employee;
import com.highradius.pojo.Orders;



public class OrderDaoImpl implements OrderDao {

	@Override
	public int insertOrder(Orders order) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(order.getEmployee());
			session.save(order.getCustomer());
			session.save(order.getShipper());
			session.save(order);
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		return 0;
		
	}

	@Override
	public int insertOrders(List<Orders> orders) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			for (Orders order : orders) {
				session.save(order);
			}
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> readAllOrders() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Orders> orders = null;
		try {
			Criteria criteria = session.createCriteria(Orders.class);
			orders = criteria.list();
			for(Orders order : orders) {
				System.out.println(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return orders;
	}

	@Override
	public Orders getOrderById(int orderId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Orders order = null;
		try {
			Criteria criteria = session.createCriteria(Orders.class);
			criteria.add(Restrictions.eq("orderId", orderId));
			order = (Orders) criteria.uniqueResult();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return order;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getOrderByCustomerId(int customerID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Orders> orders1 = null;
		try {
			Criteria criteria = session.createCriteria(Orders.class);
			criteria.add(Restrictions.eq("customer.customerId", customerID));
			orders1 = criteria.list();
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return orders1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getOrderByOrderDate(String orderDate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Orders> orders2 = null;
		try {
			Criteria criteria = session.createCriteria(Orders.class);
			criteria.add(Restrictions.eq("orderDate", orderDate));
			orders2 = criteria.list();
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return orders2;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getOrderByEmployeeId(int employeeId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Orders> orders3 = new ArrayList<Orders>();
		try {
			Criteria criteria = session.createCriteria(Orders.class);
			criteria.add(Restrictions.eq("employee.employeeId", employeeId));
			orders3 = criteria.list();
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return orders3;
	}

	@Override
	public int updateByOrderId(int orderIdForUpdate, Customer customer, Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			Orders order = (Orders) session.get(Orders.class, orderIdForUpdate);
			if (order != null) {
				order.setEmployee(employee);
				order.setCustomer(customer);
				session.update(order);
				transaction.commit();
				System.out.println("Order Updated With Success.");
			} else {
				System.out.println("order does not exist");
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return 0;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public int updateByShipperId(Orders order,Customer customer,Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Orders> orders = null;
		try {
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Orders.class);
			criteria.add(Restrictions.eq("shipper.shipperId", order.getShipper().getShipperId()));
			orders = criteria.list();
			
			
			if (orders != null) {
				for(Orders orderItem : orders) {
					orderItem.setCustomer(customer);
					orderItem.setEmployee(employee);
					session.update(orderItem);
				}
				transaction.commit();
				System.out.println("Order Updated by supplier id Successfully.");
			} else {
				System.out.println("Order does not exist.");
			} 

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return 0;
	}

	@Override
	public int deleteByOrderId(Orders order) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Orders orderToBeDelete = (Orders) session.get(Orders.class, order.getOrderId());
			if (orderToBeDelete != null) {
				session.delete(orderToBeDelete);
				System.out.println("Order deleted with success.");
			} else {
				System.out.println("Order does not exist.");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return 0;
	}

	@Override
	public int deleteByEmpId(Orders order) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Orders.class).add(Restrictions.eq("employee.employeeId", order.getEmployee().getEmployeeId()));
			@SuppressWarnings("unchecked")
			List<Orders> orderToBeDelete = criteria.list();
			
			for(Orders item : orderToBeDelete) {
				deleteByOrderId(item);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return 0;
	}

	@Override
	public int deleteByCustomerId(Orders order) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Orders.class).add(Restrictions.eq("customer.customerId", order.getCustomer().getCustomerId()));
			@SuppressWarnings("unchecked")
			List<Orders> orderToBeDelete = criteria.list();
			
			for(Orders item : orderToBeDelete) {
				deleteByOrderId(item);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return 0;
	}

	
	

}

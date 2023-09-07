package com.highradius.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.highradius.dao.CustomerDao;
import com.highradius.hibernateutil.HibernateUtil;
import com.highradius.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao {
	@Override
	public int insertCustomer(Customer customer) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(customer);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error in inserting Customer!!");
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return 0;
	}

	@Override
	public int insertCustomers(List<Customer> customers) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			for (Customer customer : customers) {
				session.save(customer);
			}
			transaction.commit();
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
	public List<Customer> getAllCustomers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Customer> customers = new ArrayList<Customer>();
		try {
			Criteria criteria = session.createCriteria(Customer.class);
			customers = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return customers;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Customer customer = null;
		try {
			Criteria criteria = session.createCriteria(Customer.class);
			criteria.add(Restrictions.eq("customerId", customerId));
			customer = (Customer) criteria.uniqueResult();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return customer;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomerByCountry(String country) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Customer> custs = null;
		try {
			Criteria criteria = session.createCriteria(Customer.class);
			criteria.add(Restrictions.eq("country", country));
			custs = criteria.list();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return custs;

	}

	@Override
	public int updateCustomer(int custId, String firstName) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, custId);
			if (customer != null) {
				customer.setCustomerName(firstName);
				session.update(customer);
				transaction.commit();
				System.out.println("Customer Updated With Success.");
			} else {
				System.out.println("Customer does not exist");
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
	public int deleteById(int custId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, custId);
			if (customer != null) {
				session.delete(customer);
				System.out.println("Customer deleted with success.");
			} else {
				System.out.println("Customer does not exist.");
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
	public int deleteByCountry(String countryToBeDeleted) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			@SuppressWarnings({ "unchecked" })
			List<Customer> customerToDelete = session.createCriteria(Customer.class)
					.add(Restrictions.eq("country", countryToBeDeleted)).list();
			if (!customerToDelete.isEmpty()) {
				for (Customer customer : customerToDelete) {
					session.delete(customer);
				}
				System.out.println(customerToDelete.size() + " customers deleted");
			} else {
				System.out.println("No customer found with the provided country name.");
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

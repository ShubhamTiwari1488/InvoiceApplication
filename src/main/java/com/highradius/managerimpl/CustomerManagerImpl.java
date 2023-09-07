package com.highradius.managerimpl;

import java.util.List;

import com.highradius.dao.CustomerDao;
import com.highradius.daoimpl.CustomerDaoImpl;
import com.highradius.manager.CustomerManager;
import com.highradius.pojo.Customer;

public class CustomerManagerImpl implements CustomerManager {

	private CustomerDao customerDao;

	@Override
	public int insertCustomer(Customer customer) {
		customerDao = new CustomerDaoImpl();
		return customerDao.insertCustomer(customer);

	}

	@Override
	public int insertCustomers(List<Customer> customers) {
		customerDao = new CustomerDaoImpl();
		return customerDao.insertCustomers(customers);
	}

	@Override
	public List<Customer> getAllCustomers() {
		customerDao = new CustomerDaoImpl();
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		customerDao = new CustomerDaoImpl();
		return customerDao.getCustomerById(customerId);

	}

	@Override
	public List<Customer> getCustomerByCountry(String country) {
		customerDao = new CustomerDaoImpl();
		return customerDao.getCustomerByCountry(country);
	}

	@Override
	public int deleteById(int custId) {
		customerDao = new CustomerDaoImpl();
		return customerDao.deleteById(custId);
	}

	@Override
	public int deleteByCountry(String countryToBeDeleted) {
		customerDao = new CustomerDaoImpl();
		return customerDao.deleteByCountry(countryToBeDeleted);
	}

	@Override
	public int updateCustomer(int customerIdToBeUpdated, String firstName) {
		customerDao = new CustomerDaoImpl();
		return customerDao.updateCustomer(customerIdToBeUpdated, firstName);
	}

}

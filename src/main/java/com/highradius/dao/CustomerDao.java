package com.highradius.dao;

import java.util.List;

import com.highradius.pojo.Customer;

public interface CustomerDao {
	int insertCustomer(Customer customer);

	int insertCustomers(List<Customer> customers);

	List<Customer> getAllCustomers();

	Customer getCustomerById(int customerId);

	List<Customer> getCustomerByCountry(String country);

	int updateCustomer(int custId, String firstName);

	int deleteById(int custId);

	int deleteByCountry(String countryToBeDeleted);
}

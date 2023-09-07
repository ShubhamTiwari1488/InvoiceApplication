package com.highradius.manager;

import java.util.List;

import com.highradius.pojo.Customer;

public interface CustomerManager {
	int insertCustomer(Customer customer);

	int insertCustomers(List<Customer> customers);

	List<Customer> getAllCustomers();

	Customer getCustomerById(int customerId);

	List<Customer> getCustomerByCountry(String country);

	int deleteById(int custId);

	int deleteByCountry(String countryToBeDeleted);

	int updateCustomer(int customerIdToBeUpdated, String firstName);
}

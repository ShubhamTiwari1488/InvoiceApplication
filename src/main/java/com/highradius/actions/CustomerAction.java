package com.highradius.actions;

import java.util.List;

import com.highradius.manager.CustomerManager;
import com.highradius.managerimpl.CustomerManagerImpl;
import com.highradius.pojo.Customer;

public class CustomerAction {

	private List<Customer> customers;

	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public String insertCustomer() {

		String s = "ERROR";
		CustomerManager customerManager = new CustomerManagerImpl();
		int result = customerManager.insertCustomer(customer);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;
	}

	public String insertCustomers() {
		String s = "ERROR";
		CustomerManager customerManager = new CustomerManagerImpl();
		int result = customerManager.insertCustomers(customers);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;
	}

	private int custId;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String readCustomerById() {
		String s = "ERROR";
		CustomerManager customerManager = new CustomerManagerImpl();
		customer = customerManager.getCustomerById(custId);
		if (customer != null) {
			s = "SUCCESS";
		}
		return s;
	}

	public String countryName;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String readCustomerByCountry() {
		String s = "ERROR";
		@SuppressWarnings("unused")
		List<Customer> custs;
		CustomerManager customerManager = new CustomerManagerImpl();
		custs = customerManager.getCustomerByCountry(countryName);
		if (customers != null) {
			s = "SUCCESS";
		}
		return s;
	}

	public String readAllCustomers() {

		String s = "ERROR";
		CustomerManager customerManager = new CustomerManagerImpl();
		customers = customerManager.getAllCustomers();
		if (customers != null) {
			s = "SUCCESS";
		}
		return s;
	}

	private int customerIdToBeUpdated;
	private String firstName;

	public int getCustomerIdToBeUpdated() {
		return customerIdToBeUpdated;
	}

	public void setCustomerIdToBeUpdated(int customerIdToBeUpdated) {
		this.customerIdToBeUpdated = customerIdToBeUpdated;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String updateCustomer() {
		String s = "ERROR";

		CustomerManager customerManager = new CustomerManagerImpl();

		int result = customerManager.updateCustomer(customerIdToBeUpdated, firstName);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;
	}

	private int customerIdToDelete;

	public int getCustomerIdToDelete() {
		return customerIdToDelete;
	}

	public void setCustomerIdToDelete(int customerIdToDelete) {
		this.customerIdToDelete = customerIdToDelete;
	}

	public String deleteCustomerByCustId() {

		String s = "ERROR";
		CustomerManager customerManager = new CustomerManagerImpl();
		int result = customerManager.deleteById(customerIdToDelete);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;

	}

	private String countryToBeDeleted;

	public String getCountryToBeDeleted() {
		return countryToBeDeleted;
	}

	public void setCountryToBeDeleted(String countryToBeDeleted) {
		this.countryToBeDeleted = countryToBeDeleted;
	}

	public String deleteCustomerByCountry() {
		String s = "ERROR";
		CustomerManager customerManager = new CustomerManagerImpl();
		int result = customerManager.deleteByCountry(countryToBeDeleted);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;
	}

}

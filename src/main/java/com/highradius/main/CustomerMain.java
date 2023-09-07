package com.highradius.main;

import com.highradius.dao.CustomerDao;
import com.highradius.daoimpl.CustomerDaoImpl;
import com.highradius.pojo.Customer;

public class CustomerMain {

	public static void main(String[] args) {
		Customer customer1 = new Customer(1, "Alfreds Futterkiste", "Maria Anders", "Obere Str. 57", "Berlin", "12209",
				"Germany");
		Customer customer2 = new Customer(2, "Ana Trujillo Emparedados y helados", "Ana Trujillo",
				"Avda. de la Constitución 2222", "México D.F.", "05021", "Mexico");
		Customer customer3 = new Customer(3, "Antonio Moreno Taquería", "Antonio Moreno", "Mataderos 2312",
				"México D.F.", "05023", "Mexico");
		Customer customer4 = new Customer(4, "Around the Horn", "Thomas Hardy", "120 Hanover Sq.", "London", "WA1 1DP",
				"UK");
		Customer customer5 = new Customer(5, "Berglunds snabbköp", "Christina Berglund", "Berguvsvägen 8", "Luleå",
				"S-958 22", "Sweden");

//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter customer id");
//		customer.setCustomerId(Integer.parseInt(sc.nextLine()));
//		System.out.println("Enter customer name:");
//		customer.setCustomerName(sc.nextLine());
//		System.out.println("Enter contact name:");
//		customer.setContactName(sc.nextLine());
//		System.out.println("Enter address:");
//		customer.setAddress(sc.nextLine());
//		System.out.println("Enter city : ");
//		customer.setCity(sc.nextLine());
//		System.out.println("Enter country: ");
//		customer.setCountry(sc.nextLine());
//		System.out.println("Enter postal Code :");
//		customer.setPostalCode(sc.nextLine());

		CustomerDao customerDao = new CustomerDaoImpl();
		customerDao.insertCustomer(customer1);
		customerDao.insertCustomer(customer2);
		customerDao.insertCustomer(customer3);
		customerDao.insertCustomer(customer4);
		customerDao.insertCustomer(customer5);

//		sc.close();

	}

}

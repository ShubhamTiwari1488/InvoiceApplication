package com.highradius.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.highradius.dao.OrderDao;
import com.highradius.daoimpl.OrderDaoImpl;
import com.highradius.pojo.Customer;
import com.highradius.pojo.Employee;
import com.highradius.pojo.Orders;
import com.highradius.pojo.Shipper;

public class OrderMain {

	public static void main(String[] args) throws IOException {
		//create employee objects 
		byte[] photo1 = Files.readAllBytes(new File("C:\\Users\\sachin.yadav\\Desktop\\employees\\emp1.jpg").toPath());
		byte[] photo2 = Files.readAllBytes(new File("C:\\Users\\sachin.yadav\\Desktop\\employees\\emp2.jpg").toPath());
		byte[] photo3 = Files.readAllBytes(new File("C:\\Users\\sachin.yadav\\Desktop\\employees\\emp3.jpg").toPath());
		byte[] photo4 = Files.readAllBytes(new File("C:\\Users\\sachin.yadav\\Desktop\\employees\\emp4.jpg").toPath());
		byte[] photo5 = Files.readAllBytes(new File("C:\\Users\\sachin.yadav\\Desktop\\employees\\emp5.jpg").toPath());
		Employee employee1 = new Employee();
		employee1.setLastName("Davilo");
		employee1.setFirstName("Nancy");
		employee1.setBirthDate("1968-12-08");
		employee1.setEmployeeId(1);
		employee1.setPhoto(photo1);
		employee1.setNotes("Education includes a BA in psychology from Colorado State University. She also completed (The Art of the Cold Call). Nancy is a member of 'Toastmasters International'.");
		
		Employee employee2 = new Employee();
		employee2.setLastName("Fuller");
		employee2.setFirstName("Andrew");
		employee2.setBirthDate("1952-02-19");
		employee2.setEmployeeId(2);
		employee2.setPhoto(photo2);
		employee2.setNotes("Andrew received his BTS commercial and a Ph.D. in international marketing from the University of Dallas. He is fluent in French and Italian and reads German. ");
		
		Employee employee3 = new Employee();
		employee3.setLastName("Leverling");
		employee3.setFirstName("Janet");
		employee3.setBirthDate("1963-08-30");
		employee3.setEmployeeId(3);
		employee3.setPhoto(photo3);
		employee3.setNotes("Janet has a BS degree in chemistry from Boston College). She has also completed a certificate program in food retailing management. Janet was hired as a sales associate and was promoted to sales representative.");
		
		Employee employee4 = new Employee();
		employee4.setLastName("Peacock");
		employee4.setFirstName("Margaret");
		employee4.setBirthDate("1958-09-19");
		employee4.setEmployeeId(4);
		employee4.setPhoto(photo4);
		employee4.setNotes("Margaret holds a BA in English literature from Concordia College and an MA from the American Institute of Culinary Arts. She was temporarily assigned to the London office before returning to her permanent post.");
		
		Employee employee5 = new Employee();
		employee5.setLastName("Buchanan");
		employee5.setFirstName("Steven");
		employee5.setBirthDate("1955-03-04");
		employee5.setEmployeeId(5);
		employee5.setPhoto(photo5);
		employee5.setNotes("Steven Buchanan graduated from St. Andrews University, Scotland, with a BSC degree. Upon joining the company as a sales representative, he spent 6 months in an orientation program at the Seattle office and then.");
		
		//create customer objects 
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
		
		//create shipper objects
		Shipper shipper1 = new Shipper(1,"Speedy Express","(503) 555-9831");
		Shipper shipper2 = new Shipper(2,"United Package","(503) 555-3199");
		Shipper shipper3 = new Shipper(3,"Federal Shipping","(503) 555-9931");
		
		
		//create order details
		Orders order1 = new Orders(10248, customer1, employee5, shipper3, "1996-07-04");
		Orders order2 = new Orders(10249, customer2, employee1, shipper1, "1996-07-05");
		Orders order3 = new Orders(10250, customer3, employee4, shipper2, "1996-07-08");
		Orders order4 = new Orders(10251, customer4, employee3, shipper1, "1996-07-08");
		Orders order5 = new Orders(10252, customer5, employee2, shipper2, "1996-07-09");
		
		OrderDao orderDao = new OrderDaoImpl();
		orderDao.insertOrder(order1);
		orderDao.insertOrder(order2);
		orderDao.insertOrder(order3);
		orderDao.insertOrder(order4);
		orderDao.insertOrder(order5);
		
	}

}

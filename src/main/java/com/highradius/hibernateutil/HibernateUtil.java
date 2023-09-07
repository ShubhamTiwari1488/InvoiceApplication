package com.highradius.hibernateutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	static {
		System.out.println("hello I am inside Static!!");
		try {
			System.out.println("Hello I am inside try!!!");
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

package com.highradius.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.highradius.dao.EmployeeDao;
import com.highradius.hibernateutil.HibernateUtil;
import com.highradius.pojo.Customer;
import com.highradius.pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public int insertEmployee(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int insertEmployees(List<Employee> employees) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			for (Employee employee : employees) {
				session.save(employee);
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

	@Override
	public Employee getEmployeeById(int empId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee = new Employee();
		try {
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("employeeId", empId));
			employee = (Employee) criteria.uniqueResult();
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return employee;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Criteria criteria = session.createCriteria(Employee.class);
			employees = criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return employees;
	}

	@Override
	public int updateEmployee(int empIdToBeUpdated, String empName) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Transaction transaction = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, empIdToBeUpdated);
			if (employee != null) {
				employee.setFirstName(empName);
				session.update(employee);
				transaction.commit();
				System.out.println("Employee Updated With Success.");
			} else {
				System.out.println("Employee does not exist");
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
	public int deleteById(int empIdToDelete) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, empIdToDelete);
			if (employee != null) {
				session.delete(employee);
				System.out.println("Employee deleted with success.");
			} else {
				System.out.println("Employee does not exist.");
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

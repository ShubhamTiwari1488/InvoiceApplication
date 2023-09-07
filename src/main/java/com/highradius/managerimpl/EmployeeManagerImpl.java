package com.highradius.managerimpl;

import java.util.List;

import com.highradius.dao.EmployeeDao;
import com.highradius.daoimpl.EmployeeDaoImpl;
import com.highradius.manager.EmployeeManager;
import com.highradius.pojo.Employee;


public class EmployeeManagerImpl implements EmployeeManager{

	private EmployeeDao employeeDao; 

	@Override
	public int insertEmployee(Employee employee) {
		employeeDao = new EmployeeDaoImpl();
		return employeeDao.insertEmployee(employee);
	}

	@Override
	public int insertEmployees(List<Employee> employees) {
		employeeDao = new EmployeeDaoImpl();
		return employeeDao.insertEmployees(employees);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		employeeDao = new EmployeeDaoImpl();
		return employeeDao.getEmployeeById(empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		employeeDao = new EmployeeDaoImpl();
		return employeeDao.getAllEmployees();
	}

	@Override
	public int updateEmployee(int empIdToBeUpdated, String empName) {
		employeeDao = new EmployeeDaoImpl();
		return employeeDao.updateEmployee(empIdToBeUpdated,empName);
	}

	@Override
	public int deleteById(int empIdToDelete) {
		employeeDao = new EmployeeDaoImpl();
		return employeeDao.deleteById(empIdToDelete);
	}
	
	

}

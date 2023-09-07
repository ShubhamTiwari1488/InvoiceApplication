package com.highradius.actions;

import java.util.List;

import com.highradius.manager.CustomerManager;
import com.highradius.manager.EmployeeManager;
import com.highradius.managerimpl.CustomerManagerImpl;
import com.highradius.managerimpl.EmployeeManagerImpl;
import com.highradius.pojo.Employee;

public class EmployeeAction {
	
	private Employee employee;
	private List<Employee> employees;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public String insertEmployee() {
		String s = "ERROR";
		EmployeeManager employeeManager = new EmployeeManagerImpl();
		int result = employeeManager.insertEmployee(employee);
		if(result > 0) {
			s = "SUCCESS";
		}
		return s;
	}
	public String insertEmployees() {
		String s = "ERROR";
		EmployeeManager employeeManager = new EmployeeManagerImpl();
		int result = employeeManager.insertEmployees(employees);
		if(result > 0) {
			s = "SUCCESS";
		}
		return s;
	}
	private int empId;

	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmployeeById() {
		
		String s = "ERROR";
		EmployeeManager employeeManager = new EmployeeManagerImpl();
		employee = employeeManager.getEmployeeById(empId);
		if (employee != null) {
			s = "SUCCESS";
		}
		return s;
	}
	
	public String getAllEmployees() {

		String s = "ERROR";
		EmployeeManager employeeManager = new EmployeeManagerImpl();
		employees = employeeManager.getAllEmployees();
		if (employees != null) {
			s = "SUCCESS";
		}
		return s;
	}
	
	private int empIdToBeUpdated;
	private String empName;

	public int getEmpIdToBeUpdated() {
		return empIdToBeUpdated;
	}

	public void setEmpIdToBeUpdated(int empIdToBeUpdated) {
		this.empIdToBeUpdated = empIdToBeUpdated;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String updateEmployee() {
		
		String s = "ERROR";
		EmployeeManager employeeManager = new EmployeeManagerImpl();

		int result = employeeManager.updateEmployee(empIdToBeUpdated, empName);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;
	}

	private int empIdToDelete;

	public int getEmpIdToDelete() {
		return empIdToDelete;
	}

	public void setEmpIdToDelete(int empIdToDelete) {
		this.empIdToDelete = empIdToDelete;
	}

	public String deleteEmployeeByEmpId() {

		String s = "ERROR";
		EmployeeManager employeeManager = new EmployeeManagerImpl();
		int result = employeeManager.deleteById(empIdToDelete);
		if (result > 0) {
			s = "SUCCESS";
		}
		return s;

	}
	
	

}

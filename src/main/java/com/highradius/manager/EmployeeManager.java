package com.highradius.manager;

import java.util.List;

import com.highradius.pojo.Employee;

public interface EmployeeManager {

	int insertEmployee(Employee employee);
	int insertEmployees(List<Employee> employees);
	Employee getEmployeeById(int empId);
	List<Employee> getAllEmployees();
	int updateEmployee(int empIdToBeUpdated, String empName);
	int deleteById(int empIdToDelete);

}

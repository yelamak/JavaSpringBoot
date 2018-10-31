package com.medplus.employee.dao;

import java.util.List;

import com.medplus.employee.bean.Employee;

public interface EmployeeDao {
	
	  int addEmployee(Employee employee);
	 void openDbConnection();
	 void closeConnection();
	 int updateEmployee(Employee employee);
	 int deleteEmployee(int employeecode);
	 List<Employee> getEmployees();
	 Employee getEmployeeById(int employeecode);
}

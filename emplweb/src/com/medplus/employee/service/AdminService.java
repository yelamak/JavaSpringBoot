package com.medplus.employee.service;

import java.util.List;

import com.medplus.employee.bean.Employee;

public interface AdminService {

	 int addEmployee(Employee employee);
	 int updateEmployee(Employee employee);
	 int deleteEmployee(int employeecode);
	 List<Employee> getEmployees();
	 Employee getEmployeeById(int employeecode);
}

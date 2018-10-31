package com.medplus.employee.service;

import java.util.List;

import com.medplus.employee.bean.Employee;

public interface UserService {

	List<Employee> getEmployees();
	 Employee getEmployeeById(int employeecode);
}

package com.medplus.employee.service.impl;

import java.util.List;

import com.medplus.employee.bean.Employee;
import com.medplus.employee.dao.EmployeeDao;
import com.medplus.employee.dao.impl.EmployeeDaoImpl;
import com.medplus.employee.service.UserService;

public class UserServiceImpl implements UserService{

	EmployeeDao dao=new EmployeeDaoImpl();
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = dao.getEmployees();
		return employees;
	}

	@Override
	public Employee getEmployeeById(int employeecode) {
		Employee emp=dao.getEmployeeById(employeecode);
		return emp;
		
	}

}

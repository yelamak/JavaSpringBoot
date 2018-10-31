package com.medplus.employee.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.medplus.employee.dao.EmployeeDao;
import com.medplus.employee.dao.impl.EmployeeDaoImpl;

public class EmployeeTest {

	EmployeeDao dao=new EmployeeDaoImpl();
	@Test
	public void test() {
		assertEquals(1, dao.deleteEmployee(21));
	}

	@Test
	public void deleteNotEqual() {
		assertNotEquals(1, dao.deleteEmployee(712));
	}
}

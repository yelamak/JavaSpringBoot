package com.medplus.employee.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.employee.bean.Employee;
import com.medplus.employee.dao.EmployeeDao;
import com.medplus.employee.utils.DBQueries;
import com.medplus.employee.utils.DateParsing;
import com.mysql.jdbc.Driver;

public class EmployeeDaoImpl implements EmployeeDao {
	
	Connection con=null;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public int addEmployee(Employee employee) {
		openDbConnection();
		int rows=0;
		try {
			ps=con.prepareStatement(DBQueries.addemp1);
		
			ps.setInt(1, employee.getEmpid());
			ps.setString(2, employee.getEmpname());
			ps.setInt(3,employee.getEmpsalary());
			ps.setDate(4, DateParsing.utilDateToSqlDateConversion(employee.getDoj()));
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		return rows;
	}

	@Override
	public  void openDbConnection() {
		String url="jdbc:mysql://localhost:3306/test";
		String user="root";
		String pass="root";
		try {
			Driver driver=new Driver();
			con=DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public int updateEmployee(Employee employee) {
		openDbConnection();
		int rows=0;
		try {
			ps=con.prepareStatement(DBQueries.updateemp);
			ps.setString(1, employee.getEmpname().trim());
			ps.setDate(2,DateParsing.utilDateToSqlDateConversion(employee.getDoj()));
			ps.setInt(3, employee.getEmpsalary());
			ps.setInt(4, employee.getEmpid());
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		return rows;
	}

	@Override
	public int deleteEmployee(int employeecode) {
		openDbConnection();
		int rows=0;
		try {
			ps=con.prepareStatement(DBQueries.deleteemp);
			ps.setInt(1, employeecode);
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		return rows;
	}

	@Override
	public List<Employee> getEmployees() {
		openDbConnection();
		List<Employee> emplist=new ArrayList<>();
		try {
			ps=con.prepareStatement(DBQueries.getempdetails);
			rs = ps.executeQuery();
			while(rs.next()) {
				Employee employee=new Employee();
				employee.setEmpid(rs.getInt(1));
				employee.setEmpname(rs.getString(2));
				employee.setEmpsalary(rs.getInt(3));
				employee.setDoj(rs.getDate(4));
				emplist.add(employee);
			}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		closeConnection();
	}
		return emplist;
	}

	@Override
	public Employee getEmployeeById(int employeecode) {
		openDbConnection();
		Employee emplo=null;
		try {
			ps=con.prepareStatement(DBQueries.getempdetailsbyid);
			ps.setInt(1, employeecode);
			rs = ps.executeQuery();
			if(rs.next()) {
				emplo=new Employee();
				emplo.setEmpid(rs.getInt(1));
				emplo.setEmpname(rs.getString(2));
				emplo.setEmpsalary(rs.getInt(3));
				emplo.setDoj(rs.getDate(4));
			}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		closeConnection();
	}
	
		return emplo;
	}
	

}

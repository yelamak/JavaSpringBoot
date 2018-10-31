package com.medplus.employee.utils;

public class DBQueries {

	public static String  addemp1="insert into employee values(?,?,?,?)";
	public static String updateemp="update employee set empname=?,doj=?,empsalary=? where empid=?";
	public static String deleteemp="delete from employee where empid=?";
	public static String getempdetails="select empid,empname,empsalary,doj from employee";
	public static String getempdetailsbyid="select empid,empname,empsalary,doj from employee where empid=?";
}

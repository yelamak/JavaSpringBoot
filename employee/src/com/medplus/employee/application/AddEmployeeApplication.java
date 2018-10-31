package com.medplus.employee.application;

import java.util.List;
import java.util.Scanner;

import com.medplus.employee.bean.Employee;
import com.medplus.employee.dao.EmployeeDao;
import com.medplus.employee.dao.impl.EmployeeDaoImpl;
import com.medplus.employee.utils.DateParsing;

public class AddEmployeeApplication {

	public static void main(String[] args) {
		Employee emp=new Employee();
		EmployeeDao dao=new EmployeeDaoImpl();
		int rows;
		int input;
		int empcode;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("enter 1-insert,2-update,3-delete,4-getAllDetails,5-getEmployeeDetailsById,6-exit");
			input=sc.nextInt();
			switch(input) {
			case 1 : System.out.println("enter id,name,salary and dateofjoin of employee");
					 emp.setEmpid(sc.nextInt());
					 emp.setEmpname(sc.next());
					 emp.setEmpsalary(sc.nextInt());
					 emp.setDoj(DateParsing.stringToUtilDateConversion(sc.next()));
					 rows=dao.addEmployee(emp);
					 if(rows>0)
					 System.out.println("inserted");
					 else
				     System.out.println("something went wrong");
					 break;
			case 2 : System.out.println("enter id and new name,salary,doj to be updated");
			 		 emp.setEmpid(sc.nextInt());
					 emp.setEmpname(sc.next());
					 emp.setEmpsalary(sc.nextInt());
					 emp.setDoj(DateParsing.stringToUtilDateConversion(sc.next()));
					 rows=dao.updateEmployee(emp);
					 if(rows>0)
					 System.out.println("updated");
					 else
				     System.out.println("something went wrong");
					 break;
			case 3 : System.out.println("enter id to be deleted");
			 		 empcode=sc.nextInt();
					 rows=dao.deleteEmployee(empcode);
					 if(rows>0)
					 System.out.println("deleted");
					 else
				     System.out.println("something went wrong");
					 break;
			case 4 : List<Employee> employees = dao.getEmployees();
					 for (Employee employee : employees) {
						System.out.println(employee.getEmpid()+" "+employee.getEmpname()+" "+employee.getEmpsalary()+" "+employee.getDoj());
					 }
					 break;
			case 5 : System.out.println("enter id to search");
					 empcode=sc.nextInt();
	 		 		 Employee employee=dao.getEmployeeById(empcode);
	 		 		 if(employee!=null)
	 		 		 System.out.println(employee.getEmpid()+" "+employee.getEmpname()+" "+employee.getEmpsalary()+" "+employee.getDoj());
	 		 		 else
	 		 			 System.out.println("id not found");
	 		 		 break;
			case 6 : break;
			default : System.out.println("invalid input");
					  break;
			}
			}while(input!=6);
		System.out.println("exited from application");
		sc.close();
	}

}

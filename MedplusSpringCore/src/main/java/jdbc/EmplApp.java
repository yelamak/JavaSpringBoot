package jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmplApp {

	public static void main(String[] args) {
		ApplicationContext ap=new ClassPathXmlApplicationContext("annotation.xml");
		
		Employee emp=ap.getBean("employee", Employee.class);
		EmployeeDao dao=ap.getBean("employeeDao", EmployeeDao.class);
		//dao.insert();
		//System.out.println("static data inserted");
		emp.setEmpid(11246);
		/*emp.setEmpname("manoj");
		emp.setEmpsalary(5000);
		emp.setDoj(DateParsing.stringToUtilDateConversion("2018-09-11"));*/
	/*	int addEmpl = dao.deleteEmpl();
		if(addEmpl>0)
			System.out.println("dynamic results saved");
		else
			System.out.println("somthing wrong");*/
		List<Employee> allEmployee = dao.getAllEmployee();
		for (Employee employee : allEmployee) {
			System.out.println(employee.toString());
		}
		emp=dao.getSingleEmployee();
		System.out.println(emp.toString());
	}
}

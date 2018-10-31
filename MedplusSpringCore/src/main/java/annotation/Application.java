package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap=new ClassPathXmlApplicationContext("annotation.xml");
		Student std=ap.getBean("student", Student.class);
		Employee emp=ap.getBean("employee", Employee.class);
		System.out.println(std.getName()+" "+emp.getAddress().getCity());
	}

}

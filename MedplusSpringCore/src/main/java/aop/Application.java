package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext ap=new ClassPathXmlApplicationContext("annotation.xml");
		Operation operation = ap.getBean("operation", Operation.class);
		operation.msg();
		operation.m();
		operation.k();
	}

}

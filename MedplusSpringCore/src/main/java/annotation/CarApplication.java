package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarApplication {

	public static void main(String[] args) {
		ApplicationContext ap= new ClassPathXmlApplicationContext("annotation.xml");
		Car car=ap.getBean("car", Car.class);
		car.moving("mrf");
	}

}

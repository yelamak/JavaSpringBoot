package core;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ap=new ClassPathXmlApplicationContext("Context.xml");
        Employee emp=ap.getBean("emp", Employee.class);
        Student st=ap.getBean("student", Student.class);
       // Address ad=ap.getBean("address", Address.class);
        Employee emp2=ap.getBean("emp", Employee.class);
        emp2.setCode(107);
        System.out.println(emp.getAddress().getCity()+" "+emp2.getCode()+" "+emp.getCode());
    }
}

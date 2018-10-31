package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackOperation {

	@Pointcut("execution(* Operation.m*(..))")
	public void k() {}//pointcut name
	
	@Before("k()")
	public void myAdvice(JoinPoint jp) {
		System.out.println("** concern before method **"+jp.getSignature());
	}
	
	@After("k()")
	public void advice(JoinPoint jp) {
		System.out.println("** concern after method **"+jp.getSignature());
	}
}

package sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/welcome")
	public String sayHello() {
		return "Hello Spring Boot";
	}
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
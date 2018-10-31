package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	@Value("101")
	private int code;
	@Value("manoj")
	private String name;
	@Autowired
	private Address add;
	public Address getAddress() {
		return add;
	}
	public void setAddress(Address address) {
		this.add = address;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}

package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	/*@Autowired
	@Qualifier("ceat")
	Wheels wheels;

	public Wheels getWheels() {
		return wheels;
	}

	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}*/
	
	public void moving(String wheeltype) {
		Wheels wh=(str)->{
			System.out.println(str+"tyres are rotating");
		};
		wh.rotating(wheeltype);
		wh.material();
		System.out.println("car is moving");
	}
	
}

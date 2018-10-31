package annotation;

public interface Wheels {

	void rotating(String sr);
	
	//in java 8 we can write definition for method making method as default 
	default void material() {
		System.out.println("tyres are made of rubber");
	}
}

package core;

public class Student {
	
	private int registrationNumber;
	@Override
	public String toString() {
		return "Student [registrationNumber=" + registrationNumber + ", name=" + name + ", marks=" + marks + "]";
	}
	private String name;
	private int marks;
	public Student(int registrationNumber, String name, int marks) {
		super();
		this.registrationNumber = registrationNumber;
		this.name = name;
		this.marks = marks;
	}
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}

}

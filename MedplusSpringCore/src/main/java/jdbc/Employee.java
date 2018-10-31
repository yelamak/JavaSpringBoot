package jdbc;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private int empid;
	private String empname;
	private int empsalary;
	private Date doj;
	public Employee(int empid, String empname, int empsalary, Date doj) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empsalary = empsalary;
		this.doj = doj;
	}
	public int getEmpid() {
		return empid;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empsalary=" + empsalary + ", doj=" + doj + "]";
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getEmpsalary() {
		return empsalary;
	}
	public void setEmpsalary(int empsalary) {
		this.empsalary = empsalary;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
}

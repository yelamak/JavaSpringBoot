package sample;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class EmployeePSS implements PreparedStatementSetter{

	@Autowired
	Employee emp;
	public EmployeePSS(Employee emp) {
		this.emp=emp;
	}
	public EmployeePSS() {
		super();
	}
	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
		System.out.println(emp.toString());
		pst.setInt(1, emp.getEmpid());
		pst.setString(2, emp.getEmpname());
		pst.setInt(3,emp.getEmpsalary());
		pst.setDate(4,DateParsing.utilDateToSqlDateConversion(DateParsing.stringToUtilDateConversion(emp.getDoj())));
		
	}
	

}

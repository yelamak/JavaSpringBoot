package sample;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class UpdateEmployeePSS implements PreparedStatementSetter {

	@Autowired
	Employee emp;
	
	public UpdateEmployeePSS(Employee emp) {
		this.emp=emp;
	}
	public UpdateEmployeePSS() {
		super();
	}
	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
		pst.setInt(4, emp.getEmpid());
		pst.setString(1, emp.getEmpname());
		pst.setInt(2,emp.getEmpsalary());
		pst.setDate(3,DateParsing.utilDateToSqlDateConversion(DateParsing.stringToUtilDateConversion(emp.getDoj())));
	
	}

}

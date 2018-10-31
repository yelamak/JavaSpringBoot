package jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class EmployeePSS implements PreparedStatementSetter{

	@Autowired
	Employee emp;
	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
		pst.setInt(4, emp.getEmpid());
		pst.setString(1, emp.getEmpname());
		pst.setInt(2,emp.getEmpsalary());
		pst.setDate(3,DateParsing.utilDateToSqlDateConversion(emp.getDoj()));
		
	}
	

}

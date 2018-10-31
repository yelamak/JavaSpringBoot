package jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class DeleteEmplPSS implements PreparedStatementSetter {

	@Autowired
	Employee emp;
	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
		pst.setInt(1, emp.getEmpid());
		
		
	}
	
}

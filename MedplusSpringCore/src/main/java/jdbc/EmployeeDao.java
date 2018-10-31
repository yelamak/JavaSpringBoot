package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao extends JdbcDaoSupport {

	@Autowired
	EmployeePSS employeePss;
	@Autowired
	DeleteEmplPSS deleteEmplPSS;
	@Autowired
	Employee emp1;
	
	@Autowired
	public EmployeeDao(DriverManagerDataSource datasource) {
		setDataSource(datasource);
	}
	public void insert() {
		String sql="insert into employee values(333,'xyz',6000,'2016-07-09')";
		getJdbcTemplate().execute(sql);
	}
	public int addEmpl(Employee emp) {
		String sql="insert into employee values(?,?,?,?)";
	/*	Object[] obj= {
				emp.getEmpid(),emp.getEmpname(),emp.getEmpsalary(),DateParsing.utilDateToSqlDateConversion(emp.getDoj())
		};
		int rows = getJdbcTemplate().update(sql, obj);*/
		int rows=getJdbcTemplate().update(sql, employeePss);
		return rows;
	}
	
	public List<Employee> getAllEmployee(){
		/*return getJdbcTemplate().query("select * from employee", new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> list=new ArrayList<Employee>();
				while(rs.next()) {
					Employee e=new Employee();
					e.setEmpid(rs.getInt(1));
					e.setEmpname(rs.getString(2));
					e.setEmpsalary(rs.getInt(3));
					e.setDoj(rs.getDate(4));
					list.add(e);
				}
				return list;
			}
			
		});*/
		List<Employee> emp = getJdbcTemplate().query("select * from employee", new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
	}
	
	public Employee getSingleEmployee() {
		Object[] args= {emp1.getEmpid()};
		Employee emp=getJdbcTemplate().queryForObject("select * from employee where empid=?", args, new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
	}
	
	public int updateEmpl() {
		String sql="update employee set empname=?,empsalary=?,doj=? where empid=?";
		int rows=getJdbcTemplate().update(sql, employeePss);
		return rows;
	}
	public int deleteEmpl() {
		String sql="delete from employee where empid=?";
		int rows=getJdbcTemplate().update(sql, deleteEmplPSS);
		return rows;
	}
}

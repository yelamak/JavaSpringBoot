import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Driver;

public class Date {

	public static void main(String[] args) throws SQLException, ParseException {
		Driver driver=new Driver();
		String url="jdbc:mysql://localhost:3306/test";
		String user="root";
		String pass="root";
		Connection con=DriverManager.getConnection(url, user, pass);
		System.out.println("connected");
		String date="12-10-2018";
		SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date doj=sd.parse(date);
		String sql="insert into employee values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, 23);
		ps.setString(2, "asdf");
		ps.setInt(3, 8000);
		ps.setDate(4, new java.sql.Date(doj.getTime()));
		int executeUpdate = ps.executeUpdate();
		if(executeUpdate>0)
			System.out.println("inserted");
		
	}
}

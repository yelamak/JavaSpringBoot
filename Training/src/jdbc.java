import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class jdbc {

	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		String url="jdbc:mysql://localhost:3306/test";
		String user="root";
		String pass="root";
		Connection con=DriverManager.getConnection(url, user, pass);
		System.out.println("connected");
		String sql="insert into employee values(?,?,?)";
		String updatesql="update employee set empsalary=? where empid=?";
		String deletesql="delete from employee where empid=?";
		String selectsql="select empid,empname,empsalary from employee";
		PreparedStatement ps=con.prepareStatement(sql);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id,name,salary");
		int id = sc.nextInt();
		
		String name=sc.next();
		int salary=sc.nextInt();
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3,salary);
		int executeUpdate = ps.executeUpdate();
		if(executeUpdate>0)
			System.out.println("inserted");
		
		System.out.println("enter id to update salary");
		 id = sc.nextInt();
		 salary=sc.nextInt();
		ps=con.prepareStatement(updatesql);
		ps.setInt(1, salary);
		ps.setInt(2, id);
		int executeUpdate2 = ps.executeUpdate();
		if(executeUpdate2>0)
			System.out.println("updated");
		System.out.println("enter id to delete salary");
		 id = sc.nextInt();
		ps=con.prepareStatement(deletesql);
		ps.setInt(1,id);
		int executeUpdate3 = ps.executeUpdate();
		if(executeUpdate3>0)
			System.out.println("delete");
		ps=con.prepareStatement(selectsql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
		}
	}

}

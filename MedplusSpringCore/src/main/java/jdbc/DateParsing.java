package jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParsing {

	public static Date stringToUtilDateConversion(String date)  {
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		Date dt=null;
		try {
			dt = sd.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dt;
	}
	
	public static java.sql.Date utilDateToSqlDateConversion(Date date){
		java.sql.Date dt=new java.sql.Date(date.getTime());
		return dt;
	}
}

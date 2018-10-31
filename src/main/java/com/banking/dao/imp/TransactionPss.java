package com.banking.dao.imp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.banking.bean.Transaction;
import com.banking.services.DateParsing;

@Component
public class TransactionPss implements PreparedStatementSetter{

	@Autowired
	Transaction ts;
	@Override
	public void setValues(PreparedStatement pss) throws SQLException {
		
		pss.setInt(1, ts.getAccountacno());
		pss.setDate(2, DateParsing.utilDateToSqlDateConversion(ts.getDateoftransaction()));
		pss.setString(3, ts.getTransactiontype());
		pss.setString(4, ts.getDescription());
		pss.setDouble(5, ts.getAmount());
		pss.setDouble(6, ts.getBalance());
	}

}

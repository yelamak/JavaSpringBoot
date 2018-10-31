package com.banking.dao.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.banking.bean.Transaction;
import com.banking.dao.TransactionDao;
import com.banking.services.DateParsing;

@Repository
public class TransactionDaoImpl extends JdbcDaoSupport implements TransactionDao{
	@Autowired
	TransactionPss pss;
	
	@Autowired
	public TransactionDaoImpl(DriverManagerDataSource datasource) {
		setDataSource(datasource);
	}

	@Override
	public int insert(Transaction tr) {
		String sql="insert into transaction values(?,?,?,?,?,?)";
		Object[] args= {tr.getAccountacno(),DateParsing.utilDateToSqlDateConversion(tr.getDateoftransaction()),tr.getTransactiontype(),null,tr.getAmount(),tr.getBalance()};
		int update = getJdbcTemplate().update(sql, pss);
		return update;
	}

	@Override
	public List<Transaction> getAllTransactionById(int acno) {
		String sql="select accountacno,date,transactiontype,description,amount,balance from transaction where accountacno=?";
		List<Transaction> allTransactions = getJdbcTemplate().query(sql,new Object[] {acno},new BeanPropertyRowMapper<Transaction>(Transaction.class));
		//getJdbcTemplate().queryForList(sql,new Object[] {acno},Class<>)
		return allTransactions;
		
	}
}

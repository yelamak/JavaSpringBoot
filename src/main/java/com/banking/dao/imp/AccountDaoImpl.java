package com.banking.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.banking.bean.Account;
import com.banking.dao.AccountDao;

@Repository
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Autowired
	public AccountDaoImpl(DriverManagerDataSource datasource) {
		setDataSource(datasource);
	}
	@Override
	public Integer getMaxNumber() {
		String sql="select Max(acno) from account";
		Integer count = getJdbcTemplate().queryForObject(sql, null,Integer.class);
		return count;
	}

	@Override
	public int insertAccount(Account ac) {
		String sql="insert into account values(?,?,?,?)";
		Object[] args= {ac.getAcno(),ac.getCustomername(),ac.getBalance(),ac.getDoc()};
		int update = getJdbcTemplate().update(sql, args);
		return update;
	}
	@Override
	public int checkAccountNo(int acno) {
		String sql="select count(*) from account where acno=?";
		Integer rows = getJdbcTemplate().queryForObject(sql, new Object[] {acno}, Integer.class);
		return rows;
	}
	@Override
	public double getBalance(int acno) {
		String sql="select balance from account where acno=?";
		Double balance=getJdbcTemplate().queryForObject(sql, new Object[] {acno},Double.class);
		return balance;
	}
	@Override
	public int updateBalance(int acno,double balance) {
		String sql="update account set balance=? where acno=?";
		Object[] args= {new Double(balance),new Integer(acno)};
		int update = getJdbcTemplate().update(sql,args);
		return update;
	}

}

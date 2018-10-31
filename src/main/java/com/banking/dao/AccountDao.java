package com.banking.dao;

import org.springframework.stereotype.Component;

import com.banking.bean.Account;

@Component
public interface AccountDao {

	Integer getMaxNumber();
	int insertAccount(Account ac);
	int checkAccountNo(int acno);
	double getBalance(int acno);
	int updateBalance(int acno,double balance);
}

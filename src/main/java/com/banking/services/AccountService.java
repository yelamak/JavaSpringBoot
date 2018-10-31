package com.banking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.AccountDao;

@Service
public class AccountService {

	@Autowired
	AccountDao accountdao;
	public int IdGeneration() {
		Integer num=accountdao.getMaxNumber();
		if(num==null)
			num=10001;
		else
			num+=1;
		return num;
	}
	
	public int AccountValidation(int acno) {
		Integer num=accountdao.checkAccountNo(acno);
		if(num==null)
			return 0;
		else
			return 1;
	}
}

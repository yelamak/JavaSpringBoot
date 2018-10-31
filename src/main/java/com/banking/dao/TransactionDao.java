package com.banking.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.banking.bean.Transaction;

@Component
public interface TransactionDao {

	int insert(Transaction tr);
	List<Transaction> getAllTransactionById(int acno);
}

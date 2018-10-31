package com.banking.bean;





import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Transaction {
	private int accountacno;
	private Date dateoftransaction;
	private String transactiontype;
	private String description;
	private double amount;
	private double balance;
	public int getAccountacno() {
		return accountacno;
	}
	public void setAccountacno(int accountacno) {
		this.accountacno = accountacno;
	}
	public Date getDateoftransaction() {
		return dateoftransaction;
	}
	public void setDateoftransaction(Date dateoftransaction) {
		this.dateoftransaction = dateoftransaction;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Transaction [accountacno=" + accountacno + ", dateoftransaction=" + dateoftransaction
				+ ", transactiontype=" + transactiontype + ", description=" + description + ", amount=" + amount
				+ ", balance=" + balance + "]";
	}
	
}

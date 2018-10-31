package com.banking.bean;

import org.springframework.stereotype.Component;

@Component
public class Address {

	private int accountacno;
	private String street;
	private String city;
	public int getAccountacno() {
		return accountacno;
	}
	public void setAccountacno(int accountacno) {
		this.accountacno = accountacno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}

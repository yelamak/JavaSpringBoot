package com.banking.dao;

import org.springframework.stereotype.Component;

import com.banking.bean.Address;

@Component
public interface AddressDao {

	int insertAddress(Address ad);
}

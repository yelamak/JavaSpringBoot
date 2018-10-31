package com.banking.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.banking.bean.Address;
import com.banking.dao.AddressDao;

@Repository
public class AddressDaoImpl extends JdbcDaoSupport implements AddressDao{

	@Autowired
	public AddressDaoImpl(DriverManagerDataSource datasource) {
		setDataSource(datasource);
	}
	@Override
	public int insertAddress(Address ad) {
		String sql="insert into Address values(?,?,?)";
		Object[] args= {ad.getAccountacno(),ad.getStreet(),ad.getCity()};
		int update = getJdbcTemplate().update(sql, args);
		return update;
	}

}

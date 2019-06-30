package com.bankwebapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bankwebapp.beans.Account;

public class BankAccMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Account a = new Account();
		a.setAccType(rs.getString("accType"));
		a.setBalance(rs.getDouble("balance"));
		a.setUser(rs.getString("user_login"));
		return a;
	}

}

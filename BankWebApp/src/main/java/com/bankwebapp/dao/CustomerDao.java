package com.bankwebapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bankwebapp.beans.Account;
import com.bankwebapp.dao.mapper.BankAccMapper;

@Service
public class CustomerDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Account> getBankInfo(String username) {
		return jdbcTemplate.query("SELECT * FROM bank_acc WHERE user_login = '" + username + "'"
				, new BankAccMapper());
	}
	
	public void depos(String username, double amount) {
		double result = jdbcTemplate.queryForObject(
			    "select balance from bank_acc where user_login='"+username+"'", Double.class);
		result += amount;
		jdbcTemplate.update("UPDATE bank_acc SET balance = " + Double.toString(result)
				+ " WHERE user_login = '" + username + "'");
	}
	
	public void withd(String username, double amount) {
		double result = jdbcTemplate.queryForObject(
			    "select balance from bank_acc where user_login='"+username+"'", Double.class);
		result -= amount;
		jdbcTemplate.update("UPDATE bank_acc SET balance = " + Double.toString(result)
				+ " WHERE user_login = '" + username + "'");
	}
}

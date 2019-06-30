package com.bankwebapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bankwebapp.beans.Account;
import com.bankwebapp.dao.mapper.BankAccMapper;

@Service
public class ManagerDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Account> getAllCurrentUsers() {
		return jdbcTemplate.query("SELECT * FROM bank_acc", new BankAccMapper());
	}
	
	public List<Account> removeUserAcc(String user) {
		jdbcTemplate.update("DELETE FROM bank_acc WHERE user_login = '" + user + "'");
		return getAllCurrentUsers();
	}
}

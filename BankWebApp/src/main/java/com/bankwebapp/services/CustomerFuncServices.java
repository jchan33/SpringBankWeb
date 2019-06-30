package com.bankwebapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankwebapp.dao.CustomerDao;
import com.bankwebapp.beans.Account;

@Service
public class CustomerFuncServices {
	
	@Autowired
	CustomerDao cusDao;
	
	public List<Account> getAccInfo(String username) {
		return cusDao.getBankInfo(username);
	}
	
	public List<Account> deposit(String username, double amount) {
		cusDao.depos(username, amount);
		return cusDao.getBankInfo(username);
	}
	
	public List<Account> withdraw(String username, double amount) {
		cusDao.withd(username, amount);
		return cusDao.getBankInfo(username);
	}
}

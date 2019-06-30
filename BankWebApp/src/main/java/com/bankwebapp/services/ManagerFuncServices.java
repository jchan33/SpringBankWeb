package com.bankwebapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankwebapp.beans.Account;
import com.bankwebapp.dao.ManagerDao;

@Service
public class ManagerFuncServices {
	
	@Autowired
	ManagerDao manDao;
	
	public List<Account> getAccInfo() {
		return manDao.getAllCurrentUsers();
	}
	
	public List<Account> remove(String user) {
		return manDao.removeUserAcc(user);
	}
}

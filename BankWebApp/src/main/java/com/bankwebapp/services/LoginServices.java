package com.bankwebapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankwebapp.beans.LoginBean;
import com.bankwebapp.dao.LoginDao;
import com.bankwebapp.services.LoginServices;

@Service
public class LoginServices {
	
	@Autowired
	LoginDao loginDaoImpl;

	public boolean authenticateUser(LoginBean loginBean) {
		return loginDaoImpl.authenticateUser(loginBean);
	}

	public String authorize(LoginBean bean) {
		return loginDaoImpl.authorize(bean);
	}
}


package com.bankwebapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bankwebapp.beans.LoginBean;

@Service
public class LoginDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginDao.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;	

	public boolean authenticateUser(LoginBean loginBean) {
		try {
		String result = jdbcTemplate.queryForObject("select user_role from user_info where user_login ='"+loginBean.getUsername()+"' and user_pass = '"+loginBean.getPassword()+"'", String.class);
		if(result != null)
			return true;
		else
			return false;
		}catch(Exception ex) {
			LOGGER.error("A stack trace!", ex);
		}
		return false;
	}

	public String authorize(LoginBean bean) {
		String result = "";
		try {
		result = jdbcTemplate.queryForObject(
			    "select user_role from user_info where user_login='"+bean.getUsername()+"'", String.class);

		}catch(Exception ex) {
			LOGGER.error("A stack trace!", ex);
		}
		return result;
	}
	

}
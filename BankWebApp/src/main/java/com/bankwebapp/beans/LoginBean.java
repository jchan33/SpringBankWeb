package com.bankwebapp.beans;

public class LoginBean {
	private String username,password; 
	  
	public LoginBean() {
	} 
	
	public LoginBean(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {  
	    return username;  
	}  
	  
	public void setUsername(String username) {  
	    this.username = username;  
	}  
	  
	public String getPassword() {  
	    return password;  
	}  
	  
	public void setPassword(String password) {  
	    this.password = password;  
	}  
}  

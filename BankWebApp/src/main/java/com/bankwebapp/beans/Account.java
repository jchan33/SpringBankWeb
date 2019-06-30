package com.bankwebapp.beans;

import org.springframework.stereotype.Component;

@Component
public class Account {
	private double balance;
	private String accType;
	private String user;
	
	public Account(double balance, String accType, String user) {
		this.balance = balance;
		this.accType = accType;
		this.user = user;
	}
	
	public Account() {
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getAccType() {
		return accType;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setBalance(double num) {
		balance = num;
	}
	
	public void setAccType(String s) {
		accType = s;
	}
	
	public void setUser(String s) {
		user = s;
	}
	
	public double Deposit(double num) {
		balance += num;
		return balance;
	}
	
	public double Withdraw(double num) {
		if (balance - num < 0)
			return balance;
		else {
			balance -= num;
			return balance;
		}
	}
}

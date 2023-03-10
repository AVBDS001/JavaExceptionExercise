package model.entities;

import javax.security.auth.login.AccountException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	
	public Account() {
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) {
		try {
			if (amount > balance || amount > withdrawLimit) {
				throw new AccountException("AMOUNT EXCEED WITHDRAW LIMIT");
			}
			else {
				balance -= amount;
			}
		}
		catch (AccountException e) {
			System.out.println("ERROR: " + e.getMessage());
			System.out.println();
		}
	}
	
}

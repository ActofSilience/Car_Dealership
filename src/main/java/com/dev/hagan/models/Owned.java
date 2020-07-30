package com.dev.hagan.models;

public class Owned {
	String username;
	int carId;
	int downpayment;
	int balance;
	int monthlyrate;
	int monthsremaining;

	@Override
	public String toString() {
		return "Owned [username=" + username + ", carId=" + carId + ", downpayment=" + downpayment + ", balance="
				+ balance + ", monthlyrate=" + monthlyrate + ", monthsremaining=" + monthsremaining + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getDownpayment() {
		return downpayment;
	}

	public void setDownpayment(int downpayment) {
		this.downpayment = downpayment;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getMonthlyrate() {
		return monthlyrate;
	}

	public void setMonthlyrate(int monthlyrate) {
		this.monthlyrate = monthlyrate;
	}

	public int getMonthsremaining() {
		return monthsremaining;
	}

	public void setMonthsremaining(int monthsremaining) {
		this.monthsremaining = monthsremaining;
	}

	public Owned(String username, int carId, int downpayment, int balance, int monthlyrate, int monthsremaining) {
		super();
		this.username = username;
		this.carId = carId;
		this.downpayment = downpayment;
		this.balance = balance;
		this.monthlyrate = monthlyrate;
		this.monthsremaining = monthsremaining;
	}

	public Owned() {
		super();
	}

}
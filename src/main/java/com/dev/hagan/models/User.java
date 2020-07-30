package com.dev.hagan.models;

public class User {

	String username;
	String password;
	int isEmployee;
	int payment;

	public User() {
		super();
	}





	public User(String username, String password, int isEmployee) {
		super();
		this.username = username;
		this.password = password;
		this.isEmployee = isEmployee;
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


	public int getIsEmployee() {
		return isEmployee;
	}


	public void setIsEmployee(int isEmployee) {
		this.isEmployee = isEmployee;
	}


	

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", isEmployee="
				+ isEmployee + "]";
	}

}

package com.dev.hagan.service;

import java.util.List;

import com.dev.hagan.dao.UserDAO;
import com.dev.hagan.dao.UserDAOImpl;
import com.dev.hagan.models.User;

public class UserService {
	public static UserDAO ud = new UserDAOImpl();

	public static User getUser(String username) {
		return ud.getUser(username);
	}

	public static List<User> getAllUser() {
		return ud.getAllUser();
	}

	public static boolean updateUser(String username) {
		return ud.updateUser(username);
	}

	public static boolean addUser(User username) {
		return ud.addUser(username);
	}

	public static boolean deleteUser(String username) {
		return ud.deleteUser(username);
	}

	public static User getUsername(String username) {
		return ud.getUsername(username);
	}

}

package com.dev.hagan.dao;

import java.util.List;

import com.dev.hagan.models.User;

public interface UserDAO {

	public User getUser(String username);

	public List<User> getAllUser();

	public boolean updateUser(String username);

	public boolean deleteUser(String username);

	public boolean addUser(User username);

	public User getUsername(String username);

}
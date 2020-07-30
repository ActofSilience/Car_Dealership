package com.dev.hagan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dev.hagan.models.User;
import com.dev.hagan.util.DBConnect;

public class UserDAOImpl implements UserDAO {
	Connection conn = DBConnect.getConnection();



	public User getUser(String username) {
		try {

			String sql = "SELECT * FROM cardealership_users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username); 

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				User u = new User();

				u.setUsername(rs.getString("USERNAME"));
				u.setPassword(rs.getString("PASSWORD"));
				u.setIsEmployee(rs.getInt("ISEMPLOYEE"));


				return u;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<User> getAllUser() {
		try {

			String sql = "SELECT * FROM cardealership_users";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<User> users = new ArrayList<User>();

			while (rs.next()) {

				users.add(new User( rs.getString("USERNAME"),
						rs.getString("PASSWORD"),rs.getInt("ISEMPLOYEE")));

			}

			return users;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean updateUser(String username) {
		try {
			String sql = "UPDATE cardealership_users SET isemployee = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, 1);

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteUser(String username) {
		try {

			String sql = "DELETE cardealership_users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean addUser(User username) {
		try {

			String sql = "Call ADD_USER( ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, username.getUsername());
			cs.setString(2, username.getPassword());
			cs.setInt(3, username.getIsEmployee());


			
			cs.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public User getUsername(String username) {
		try {

			String sql = "SELECT * FROM cardealership_users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				User u = new User();
				u.setUsername(rs.getString("USERNAME"));
				u.setIsEmployee(rs.getInt("ISEMPLOYEE"));
				u.setPassword(rs.getString("PASSWORD"));



				return u;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}


}
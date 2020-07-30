package com.dev.hagan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dev.hagan.models.Owned;
import com.dev.hagan.util.DBConnect;

public class OwnedDAOImpl implements OwnedDAO {
	public static Connection conn = DBConnect.getConnection();
	public List<Owned> getOwned(String username) {
		try {

			String sql = "SELECT * FROM cardealership_soldcars WHERE USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
		
			ResultSet rs = ps.executeQuery();

			List<Owned> owned = new ArrayList<Owned>();

			while (rs.next()) {

				owned.add(new Owned(rs.getString("USERNAME"), rs.getInt("CAR_ID"), rs.getInt("DOWNPAYMENT"), rs.getInt("BALANCE"),rs.getInt("MONTHLYRATE"), rs.getInt("MONTHSREMAINING")));

			}

			return owned;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}

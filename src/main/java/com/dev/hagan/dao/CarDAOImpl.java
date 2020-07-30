package com.dev.hagan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.hagan.models.Car;
import com.dev.hagan.models.User;
import com.dev.hagan.util.DBConnect;

public class CarDAOImpl implements CarDAO {
	public static Connection conn = DBConnect.getConnection();

	

	public Car getCar(int carId) {

		try {

			String sql = "SELECT * FROM cardealership_cars WHERE car_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, carId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Car c = new Car();
				c.setCarId(rs.getInt("CAR_ID"));
				c.setCarBrand(rs.getString("BRAND"));
				c.setCarModel(rs.getString("MODEL"));
				c.setMileage(rs.getInt("MILEAGE"));
				c.setPrice(rs.getInt("PRICE"));
				c.setYear(rs.getInt("YEAR"));

				return c;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Car> getAllCars() {

		try {

			String sql = "SELECT * FROM cardealership_cars";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<Car> cars = new ArrayList<Car>();

			while (rs.next()) {

				cars.add(new Car(rs.getInt("CAR_ID"), rs.getInt("YEAR"), rs.getString("MODEL"), rs.getString("BRAND"),
						rs.getInt("MILEAGE"), rs.getInt("PRICE")));

			}

			return cars;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean addCar(Car carId) {

		try {

			String sql = "CALL add_car(?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, carId.getYear());
			cs.setString(2, carId.getCarModel());
			cs.setString(3, carId.getCarBrand());
			cs.setInt(4, carId.getMileage());
			cs.setInt(5, carId.getPrice());

			cs.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteCar(int carId) {
		try {

			String sql = "DELETE cardealership_cars WHERE car_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, carId);

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	
}
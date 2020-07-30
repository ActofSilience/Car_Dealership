package com.dev.hagan.service;

import java.util.List;

import com.dev.hagan.dao.CarDAO;
import com.dev.hagan.dao.CarDAOImpl;
import com.dev.hagan.models.Car;

public class CarService {
	public static CarDAO cd = new CarDAOImpl();

	public static Car getCar(int carId) {
		return cd.getCar(carId);
	}

	public static List<Car> getAllCars() {
		return cd.getAllCars();
	}

	public static boolean addCar(Car carId) {
		return cd.addCar(carId);
	}

	public static boolean deleteCar(int carId) {
		return cd.deleteCar(carId);
	}
}

package com.dev.hagan.dao;

import java.util.List;

import com.dev.hagan.models.Car;
import com.dev.hagan.models.User;

public interface CarDAO {

	

	public Car getCar(int carId);

	public List<Car> getAllCars();

	public boolean addCar(Car carId);

	public boolean deleteCar(int carId);

}


package com.dev.hagan.models;

public class Car {

	int carId;
	int year;
	String carModel;
	String carBrand;
	int mileage;
	int price;
	
	public Car() {
		super();
	}

	public Car(int carId, int year, String carModel, String carBrand, int mileage, int price) {
		super();
		this.carId = carId;
		this.year = year;
		this.carModel = carModel;
		this.carBrand = carBrand;
		this.mileage = mileage;
	
	}



	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", year=" + year + ", carModel=" + carModel + ", carBrand=" + carBrand
				+ ", mileage=" + mileage + ", price=" + price +  "]";
	}

	

}

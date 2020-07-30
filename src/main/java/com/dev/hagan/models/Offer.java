package com.dev.hagan.models;

public class Offer {
	int offerId;
	int carId;
	String username;
	String status;
	int downPayment;


	public Offer() {
		super();
	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", carId=" + carId + ", username=" + username + ", status=" + status
				+ ", downPayment=" + downPayment + "]";
	}

	public Offer(int offerId, int carId, String username, String status, int downPayment) {
		super();
		this.offerId = offerId;
		this.carId = carId;
		this.username = username;
		this.status = status;
		this.downPayment = downPayment;
	
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(int downPayment) {
		this.downPayment = downPayment;
	}


	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getOfferId() {
		return offerId;
	}

}

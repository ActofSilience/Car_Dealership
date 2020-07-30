package com.dev.hagan.menus;

import java.util.Scanner;

import com.dev.hagan.loggers.JLogger;
import com.dev.hagan.models.Car;
import com.dev.hagan.models.Offer;
import com.dev.hagan.service.CarService;
import com.dev.hagan.service.OfferService;
import com.dev.hagan.service.OwnedService;
import com.dev.hagan.service.UserService;

public class CustomerMenu {

	static int inputInt;

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in); // initialize scanner

			System.out.println("Please choose from the list of options:");
			System.out.println("1. Make an offer on a car");
			System.out.println("2. View offer status");
			System.out.println("3. Retrieve vehicles I own");
			System.out.println("4. View payment plan ");
			System.out.println("5. Logout");
			System.out.println("6. Quit ");

			String input = sc.nextLine();
			inputInt = Integer.parseInt(input);

			if (inputInt == 1) {

				String offerChoice;
				String downPayment;
				String paymentUser;
				int offerInt;
				int downInt;

				System.out.println("Which vehicle would you like to make an offer on?");
				System.out.println(CarService.getAllCars()); // List all cars

				offerChoice = sc.nextLine();
				offerInt = Integer.parseInt(offerChoice);
				System.out.println("How much down payment would you like to make on this car?");

				downPayment = sc.nextLine();// get offer payment
				downInt = Integer.parseInt(downPayment);
				System.out.println("Please enter your name to finalize the offer:");
				paymentUser = sc.nextLine(); // Add offer to username
				UserService.getUsername(paymentUser);

				System.out.println("");

				System.out.println("Offer submitted, pending approval");

				Offer offer = new Offer(); // Make new offer object

				offer.setCarId(offerInt);
				offer.setUsername(paymentUser);
				offer.setDownPayment(downInt);
				offer.setStatus("Pending");

				System.out.println(OfferService.addOffer(offer)); // Add offer to db
				JLogger.logger.info("Offer added");
				CustomerMenu.main(args);

			} else if (inputInt == 2) {
				System.out.println("Please enter username");
				String username;
				username = sc.nextLine();

				System.out.println("Here are the vehicles you have made offers on, " + username);
				System.out.println(OfferService.getUserOffers(username));

				CustomerMenu.main(args);
				
			} else if (inputInt == 3) {
				System.out.println("Enter your username: ");
				String username = sc.nextLine();

				System.out.println(OwnedService.getOwned(username));

				CustomerMenu.main(args);

			} else if (inputInt == 4) {
				System.out.println("Your monthly payment is: ");
				//ToDo not implemented
				CustomerMenu.main(args);

			} else if (inputInt == 5) {
				Home.main(args);

			} else if (inputInt == 6) {
				System.out.println("Program exiting");
				JLogger.logger.info("Program closed");
				System.exit(0);
			}
		} catch (NumberFormatException e) {
			JLogger.logger.warn("Exception caught");
			System.out.println("Please enter a valid number " + e);
			CustomerMenu.main(args);
		}

	}
}

package com.dev.hagan.menus;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.dev.hagan.loggers.JLogger;
import com.dev.hagan.models.Car;
import com.dev.hagan.models.Offer;
import com.dev.hagan.service.CarService;
import com.dev.hagan.service.OfferService;
import com.dev.hagan.service.OwnedService;
import com.dev.hagan.service.UserService;
import com.dev.hagan.util.DBConnect;

public class EmployeeMenu {

	static String input;
	static int inputInt;
	static String choice;
	static int choiceInt;
	static String userLoggedIn;
	

	public static void main(String[] args) {

		while (inputInt >= 5 || inputInt <= 0) { // loop until valid input
			try {

				Scanner sc = new Scanner(System.in); // initialize scanner

				System.out.println("Please choose from the list of options:");
				System.out.println("1. Add car to lot ");
				System.out.println("2. Remove cars from the lot ");
				System.out.println("3. Decide on pending offers");
				System.out.println("4. Make user an employee ");
				System.out.println("5. View payments");
				System.out.println("6. Delete users");
				System.out.println("7. Logout ");
				System.out.println("8. Quit program ");

				input = sc.nextLine();
				inputInt = Integer.parseInt(input);

				if (inputInt == 1) {
					
					String brand;
					String year;
					String model;
					String mileage;
					String price;
					System.out.println("What brand of vehicle is being entered?: ");
					brand = sc.nextLine();
					System.out.println(brand);

					System.out.println("What year model is the vehicle?: ");
					year = sc.nextLine();
					System.out.println(year + " " + brand);

					System.out.println("What model vehicle is it?: ");
					model = sc.nextLine();
					System.out.println(year + " " + brand + " " + model);

					System.out.println("Set the price: ");
					
					price = sc.nextLine();
					System.out.println(year + " " + brand + " " + model + ", " + price);

					System.out.println("How many miles are on the vehicle?: ");
					mileage = sc.nextLine();
					String carIdString = year + " " + brand + " " + model + ", " + mileage + " miles, $" + price;
					System.out.println(carIdString);

					Car car = new Car();
					car.setYear(Integer.parseInt(year));
					car.setCarBrand(brand);
					car.setCarModel(model);
					car.setMileage(Integer.parseInt(mileage));
					car.setPrice(Integer.parseInt(price));

					CarService.addCar(car);

					System.out.println("Car added");
					
					
				}

				else if (inputInt == 2) {
					int deleteId;
					System.out.println("Which vehicle would you like to remove from the lot?");
					System.out.println(CarService.getAllCars());

					deleteId = sc.nextInt();
					CarService.deleteCar(deleteId);
					System.out.println(CarService.deleteCar(deleteId));

					System.out.println("Vehicle removed from lot");

					

				}

				else if (inputInt == 3) {

					String choiceOffer;

					try {

						System.out.println("Here are offers that customers have made:");
						System.out.println(OfferService.getAllOffers());

						System.out.println("Choose a number to make reject or approve");

						choiceOffer = sc.nextLine();
						choiceInt = Integer.parseInt(choiceOffer);

						OfferService.getOffer(choiceInt);

						System.out.println("Do you approve or reject this offer?");
						choice = sc.nextLine();

						if (choice.equalsIgnoreCase("approve")) {
							Offer offer = OfferService.getOffer(choiceInt); 
	
							System.out.println(OfferService.updateOfferApprove(offer));
							System.out.println(OfferService.updateOfferReject(offer));
							
							String sql = "CALL ADD_OWNED(?,?,?)";
							Connection conn = DBConnect.getConnection();
							CallableStatement cs = conn.prepareCall(sql); 
							cs.setString(1, offer.getUsername());
							cs.setInt(2, offer.getCarId());
							cs.setInt(3, offer.getDownPayment());
							cs.execute();

							String sql2 = "CALL ADD_PRICE()"; 
							CallableStatement cs2 = conn.prepareCall(sql2);
							cs2.execute(); 
							String sql3 = "CALL UPDATE_PAYMENTS()"; 
							CallableStatement cs3 = conn.prepareCall(sql3);
							cs3.execute();
							
							
						}

						else if (choice.equalsIgnoreCase("reject")) {
							Connection conn = DBConnect.getConnection();

							String sql = "UPDATE cardealership_offers SET STATUS = 'Rejected' WHERE OFFER_ID = "
									+ choiceInt;
							Statement ps = conn.prepareStatement(sql);
							ps.execute(sql);

						}

					} catch (NumberFormatException e) {
						System.out.println("Please make a valid choice " + e);
						EmployeeMenu.main(args);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} else if (inputInt == 4) {
					System.out.println("Enter a username that you would like to elevate to an employee:");
					System.out.println(UserService.getAllUser());

					String choice;

					choice = sc.nextLine();
					Connection conn = DBConnect.getConnection();

					String sql = "UPDATE cardealership_users SET ISEMPLOYEE = 1 WHERE USERNAME = " + "'" + choice + "'";
					Statement ps = conn.prepareStatement(sql);
					ps.execute(sql);

					System.out.println(choice + "is now classified as an employee");

					
					
				
				}

				else if (inputInt == 5) {
					System.out.println("Here are payments that customers have made:");

					

					EmployeeMenu.main(args);
				}

				else if (inputInt == 6) {

					System.out.println("Select a username to delete");
					String userDelete;
					System.out.println(UserService.getAllUser());
					userDelete = sc.nextLine();

					UserService.deleteUser(userDelete);

					System.out.println("User deleted");
					JLogger.logger.warn("User deleted");
				
				}

				else if (inputInt == 7) {
					Home.main(args);

				}

				else if (inputInt == 8) {
					sc.close();
					JLogger.logger.info("Program closed");
					System.exit(0);

				}

				else if (inputInt >= 8 || inputInt <= 0) // if input invalid, display text and retry
				{
					System.out.println("Please enter a valid number option");
				}
			}

			catch (NumberFormatException e) {
				System.out.println("Please enter a number " + e);
				JLogger.logger.warn("Exception caught");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

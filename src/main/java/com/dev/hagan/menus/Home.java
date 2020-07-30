package com.dev.hagan.menus;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.dev.hagan.loggers.JLogger;
import com.dev.hagan.models.User;
import com.dev.hagan.service.CarService;
import com.dev.hagan.service.UserService;

public class Home {

	static String input;
	static int inputInt;

	public static void main(String[] args) {
		JLogger.logger.info("Program Started");

		System.out.println("Please pick an option:"); // display menu options
		System.out.println("1. Login");
		System.out.println("2. Browse cars in the lot");
		System.out.println("3. Register");
		System.out.println("4. Employee login");
		System.out.println("5. Quit");

		Scanner sc = new Scanner(System.in); // initialize scanner

		while (inputInt >= 5 || inputInt <= 0) { // loop until valid input
			try {
				input = sc.nextLine();
				inputInt = Integer.parseInt(input);

				if (inputInt == 1) { // if input = 1 go to login menu

					Login.main(args);

				} else if (inputInt == 2) { // if input = 2 go to car lot menu
					System.out.println("These are the vehicles we have on the lot currently:");
					System.out.println(CarService.getAllCars());
				
					Home.main(args);
				
				} else if (inputInt == 3) { // if input = 3 go to user registration menu
					Register.main(args);
				}

				else if (inputInt == 4) { // if input = 4 end program
					System.out.println("Please enter your username:");
					String username = sc.nextLine(); // scan input for username
					System.out.println("Please enter the password for user " + "'" + username + "'" + "");
					String passcode = sc.nextLine();
					
					User user = UserService.getUser(username);//Get username + password from db
					if	(user.getPassword().compareTo(passcode) == 0 & user.getIsEmployee() == 1) {
						EmployeeMenu.main(args);
				}
					else if(inputInt == 5);
					System.exit(0);

				} while (inputInt >= 6 || inputInt <= 0) { // if input invalid, display text and retry
					System.out.println("Please enter a valid number");
				}
			}

			catch (InputMismatchException e) {
				System.out.println("Please enter a number " + e);
				JLogger.logger.warn("Exception caught");

			}

		}
	}
}

package com.dev.hagan.menus;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.dev.hagan.loggers.JLogger;
import com.dev.hagan.models.User;
import com.dev.hagan.service.UserService;

public class Login {

	static String username;
	static String passcode;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // Start scanner

		try {

			System.out.println("Please enter your username:");
			username = sc.nextLine(); // scan input for username
			System.out.println("Please enter the password for user " + "'" + username + "'" + "");
			passcode = sc.nextLine();

			User user = UserService.getUser(username);// Get username + password from db
			if (user.getPassword().compareTo(passcode) == 0) { // compare username and password entered versus db
				System.out.println("Success");
				JLogger.logger.info("Customer logged in successfully");
				CustomerMenu.main(args); // Change to customer menu
			}

		} catch (InputMismatchException e) {
			JLogger.logger.warn("Exception caught");
			System.out.println("Please enter valid credentials " + e);

		}
	}
}
package com.dev.hagan.menus;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.dev.hagan.loggers.JLogger;
import com.dev.hagan.models.User;
import com.dev.hagan.service.UserService;

public class Register {

	static String username;
	static String passcode;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		try {

			System.out.println("Please enter what you would like your username to be:");
			username = scan.nextLine();

			System.out.println("Please set your passcode:");
			passcode = scan.nextLine();

			User user = new User();

			user.setUsername(username);
			user.setPassword(passcode);

			System.out.println("User added = " + UserService.addUser(user));
			JLogger.logger.info("New user added");
			Home.main(args);

		} catch (InputMismatchException e) {
			System.out.println("Invalid data entry " + e);
			JLogger.logger.warn("Exception caught");
		}

	}
}

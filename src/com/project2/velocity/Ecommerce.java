package com.project2.velocity;

import java.util.Scanner;

public class Ecommerce {

	static UserDetails user = new UserDetails();
	static Scanner sc = new Scanner(System.in);
	static String perform = "";

	public static void callMethod() {
		System.out.println();
		System.out.println("enter your choice>> ");
		int i = sc.nextInt();
		switch (i) {
		case 1:
			user.userResistration();
			callMethod();
			break;
		case 2:
			user.userLogin();
			callMethod();
			break;
		case 3:
			user.viewProductSortedOrder();
			callMethod();
			break;
		case 4:
			user.buyProduct();
			callMethod();
			break;
		case 5:
			user.viewCart(user.getMap1());
			System.out.println("product items has been added to cart");
			callMethod();
			break;
		case 6:
			user.purchesItem();
			System.out.println("you have placed the order successfully");
			break;
		}
	}

	public static void getUserChoice() {
		System.out.println();
		System.out.println("if you want/don't want to buy another product? press(y/n) ");
		System.out.println("Enter y/n - ");
		perform = sc.next();
		if (perform.equalsIgnoreCase("y")) {
			user.buyProduct();
		} else {
			System.out.println("----thank you--------");
			// System.exit(0);
			callMethod();
		}
	}

}

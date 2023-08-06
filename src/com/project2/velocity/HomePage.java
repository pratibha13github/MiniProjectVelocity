package com.project2.velocity;

import java.util.Scanner;

public class HomePage {
	Scanner sc = new Scanner(System.in);

	public void getHomePage() {
		System.out.println("          Welcome to E-Commerce based application");
		System.out.println();
		System.out.println("    User Menu");
		System.out.println("1 for User registration");
		System.out.println("2 for User login");
		System.out.println("3 for User view Product item as Sorted Order");
		System.out.println("4 for Buy product");
		System.out.println("5 for View cart");
		System.out.println("6 for Total Amount");

		System.out.println();
		Ecommerce.callMethod();
	}

	// public static void main(String[] args) {
	// HomePage hp = new HomePage();
	// hp.getHomePage();
	// }
}

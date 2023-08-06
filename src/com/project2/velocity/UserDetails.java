package com.project2.velocity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class UserDetails implements UserOperation {
	ResultSet set;
	Set<Integer> set2;
	PreparedStatement ps2;
	Scanner sc = new Scanner(System.in);
	ConnectionWithSQL cs = new ConnectionWithSQL();
	HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();

	public HashMap<Integer, Integer> getMap1() {
		return map1;
	}

	public void setMap1(HashMap<Integer, Integer> map1) {
		this.map1 = map1;
	}

	int totalPrice = 0;
	int amount = 0;
	static Connection con2 = null;
	PreparedStatement ps = null;
	String currentUser = null;

	@Override
	public void userResistration() {

		try {
			ConnectionWithSQL cws = new ConnectionWithSQL();
			con2 = cws.getConnectionDetails();
			String query = "insert into registration (firstname,lastname,username,userpassword,city,mailid,mobilenumber)"
					+ " values (?,?,?,?,?,?,?)";

			ps = con2.prepareStatement(query);
			System.out.println("enter first name");
			String name = sc.next();
			ps.setString(1, name);
			System.out.println("enter last name");
			String lname = sc.next();
			ps.setString(2, lname);
			System.out.println("enter user name");
			String uname = sc.next();
			ps.setString(3, uname);
			System.out.println("enter password");
			String pwd = sc.next();
			ps.setString(4, pwd);
			System.out.println("enter city name");
			String ct = sc.next();
			ps.setString(5, ct);
			System.out.println("enter mail id");
			String mailId = sc.next();
			ps.setString(6, mailId);
			System.out.println("enter mobile number");
			String mobNum = sc.next();
			ps.setString(7, mobNum);
			System.out.println(query);
			// Execute Query
			int i = ps.executeUpdate();
			con2.close();
			ps.close();
			// track the result
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void userLogin() {
		try {
			ConnectionWithSQL cws = new ConnectionWithSQL();
			con2 = cws.getConnectionDetails();
			String query = "select * from registration where username=?";
			ps = con2.prepareStatement(query);
			System.out.println("enter user Name");
			String userName = sc.next();
			ps.setString(1, userName);
			currentUser = userName;
			System.out.println("enter password");
			String pwd = sc.next();
			// ps.setString(2, pwd);
			ResultSet set3 = ps.executeQuery();
			String un = null;
			String pw = null;
			while (set3.next()) {
				un = set3.getString(3);
				pw = set3.getString(4);
				System.out.println(pwd);
			}
			if (userName.equals(un) && pwd.equals(pw)) {
				System.out.println("login successful");
			} else {
				System.out.println("incorrect user name and password");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void viewProductSortedOrder() {
		try {
			Connection con3 = cs.getConnectionDetails();
			String query = "select * from product";
			PreparedStatement ps2 = con3.prepareStatement(query);
			ResultSet set = ps2.executeQuery();
			while (set.next()) {
				System.out.println("ID - " + set.getInt(1));
				System.out.println("product name- " + set.getString(2));
				System.out.println("product discription- " + set.getString(3));
				System.out.println("product price- " + set.getInt(4));
				System.out.println("product quantity- " + set.getInt(5));
				System.out.println();
			}
			con3.close();
			ps2.close();
			set.close();

		} catch (Exception e) {
		}
	}

	@Override
	public HashMap<Integer, Integer> buyProduct() {

		System.out.print("enter the product id to buy product>> ");
		int pId1 = sc.nextInt();
		System.out.print("enter quantity>> ");
		int pQuantity = sc.nextInt();
		if (map1.containsKey(pId1)) {
			Integer oldQuantity = map1.get(pId1);
			oldQuantity = oldQuantity + pQuantity;
			map1.put(pId1, oldQuantity);
		} else {
			map1.put(pId1, pQuantity);
		}
		System.out.println();
		System.out.print("do you want to view cart(yes/no)>> ");
		String ch = sc.next();
		if (ch.equals("yes")) {
			viewCart(map1);
		} else {
			Ecommerce.getUserChoice();
		}

		return map1;
	}

	@Override
	public void viewCart(HashMap<Integer, Integer> map1) {
		try {
			Connection con4 = cs.getConnectionDetails();
			Set<Integer> set2 = map1.keySet();
			for (int k : set2) {
				String query = "select * from product where productId=?";
				PreparedStatement ps2 = con4.prepareStatement(query);
				System.out.println("Id>> " + k);
				System.out.println("Quantity>> " + map1.get(k));
				ps2.setInt(1, k);
				ResultSet set = ps2.executeQuery();
				while (set.next()) {
					totalPrice = set.getInt(4) * map1.get(k);
					System.out.println("ID - " + set.getInt(1));
					System.out.println("product name- " + set.getString(2));
					System.out.println("product discription- " + set.getString(3));
					System.out.println("product price- " + set.getInt(4));
					System.out.println("______________________________________");
					System.out.println("product total price " + totalPrice);
					System.out.println("_______________________________________");
					amount = amount + totalPrice;
					System.out.println();
				}
			}

			con4.close();
			ps2.close();
			set.close();

		} catch (Exception e) {
		}
	}

	public void purchesItem() {

		System.out.println("*******************************************");
		System.out.println("user name>> " + currentUser);
		System.out.println("total bill amount>> " + amount);
	}

}

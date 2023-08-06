package com.project2.velocity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Product {
	static Connection con2 = null;
	PreparedStatement ps = null;

	public void insertProductDetails(int productId, String productName, String Discription, int price,
			int availableQuantity) {
		try {
			ConnectionWithSQL cws = new ConnectionWithSQL();
			con2 = cws.getConnectionDetails();
			String query = "insert into product (productId,productName,Discription,price,availableQuantity)"
					+ " values (?,?,?,?,?)";

			ps = con2.prepareStatement(query);
			ps.setInt(1, productId);
			ps.setString(2, productName);
			ps.setString(3, Discription);
			ps.setInt(4, price);
			ps.setInt(5, availableQuantity);
			// Execute Query
			int i = ps.executeUpdate();
			con2.close();
			ps.close();
			// track the result
			System.out.println(i + " row's inserted Successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertProduct(int input) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= input; i++) {
			System.out.println("enter product id");
			int id = sc.nextInt();
			System.out.println("enter product name");
			String name = sc.next();
			System.out.println("enter product discription");
			String dis = sc.next();
			System.out.println("enter product price");
			int pri = sc.nextInt();
			System.out.println("enter product quantity");
			int quantity = sc.nextInt();
			this.insertProductDetails(id, name, dis, pri, quantity);

		}
	}
}
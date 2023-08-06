package com.project2.velocity;

import java.util.HashMap;

public interface UserOperation {
	public abstract void userResistration();

	public abstract void userLogin();

	public abstract void viewProductSortedOrder();

	public abstract HashMap<Integer, Integer> buyProduct();

	public abstract void viewCart(HashMap<Integer, Integer> map1);

	public abstract void purchesItem();

}

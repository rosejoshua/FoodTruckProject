package com.skilldistillery.foodtruck;

public class FoodTruck {
	
	private static int nextId=0;
	private int id;
	private String name;
	private String foodType;
	private double rating;
	
	public FoodTruck(String name, String foodType, double rating) {
		this.id = nextId;
		nextId++;
		
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}

}

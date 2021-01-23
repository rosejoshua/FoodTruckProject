package com.skilldistillery.foodtruck;

public class FoodTruck {
	
	private static int nextId=0;
	private int id;
	private String name;
	private String foodType;
	private double rating;
	
	public FoodTruck(String name) {
		this.id = nextId;
		nextId++;
		
		this.name = name;
		this.foodType = "undecided";
		this.rating = 0.0;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getFoodType() {
		return foodType;
	}

	public double getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "[ID = " + id + ", Name = " + name + ", Food Type = " + foodType + ", Rating = " + rating + "]";
	}
	
	
	
}

package com.skilldistillery.foodtruck;

import java.util.Scanner;

//instances of FoodTruckApp will be able to use Scanner to take in user choices for app menu. Main method uses boolean run and while loop for 
//continuous menu use until user inputs "quit" menu choice. This will set run to false and allow termination.
public class FoodTruckApp {

	private Scanner input = new Scanner(System.in); //Scanner to be used by FoodTruckApp object for taking in user's menu choices and passing args to FoodTruck constructor
	private FoodTruck foodTruckArray[] = new FoodTruck[5];//Array for storing FoodTruck objects

	public static void main(String[] args) {
		boolean run = true;
		int choice = 0;

		FoodTruckApp instance = new FoodTruckApp(); //FoodTruckApp object used for calling FoodTruckApp methods

		while (run) { //continuous loop to reprint menu until quitting
			instance.printMenu();
			choice = instance.input.nextInt();
			instance.input.nextLine();
			if (choice < 1 && choice > 5) {
				System.out.println("invalid choice, try again");
			} else if (choice == 5) {
				System.out.println("Exiting program..."); 
				run = false;
			} else {
				instance.choiceHandler(choice, instance.foodTruckArray); //method call for handling choices 1-4
			}
		}

		instance.input.close(); //Scanner closed
	}

	private void printMenu() { 
		System.out.println("************************************");
		System.out.println("*  <<<<<<  FOOD TRUCK APP  >>>>>>  *");
		System.out.println("************************************");
		System.out.println("*        Choose an option (1-5):   *");
		System.out.println("************************************");
		System.out.println("* > 1. Add food trucks (5 max)     *");
		System.out.println("* > 2. List all food trucks        *");
		System.out.println("* > 3. See combined average rating *");
		System.out.println("* > 4. Show highest rated          *");
		System.out.println("* > 5. Quit                        *");
		System.out.println("************************************");

	}

	private void choiceHandler(int choice, FoodTruck foodTruckArray[]) { //calls other methods for choices 1-4 and passes foodTruckArray[]

		if (choice == 1) {
			arrayBuilder(choice, foodTruckArray);
		}

		else if (choice == 2) {
			truckPrinter(foodTruckArray);
		}
		
		else if (choice == 3) {
			getAverageRating(foodTruckArray);
		}
		else if (choice ==4) {
			showHighestRated(foodTruckArray);
		}
	}

	private void arrayBuilder(int choice, FoodTruck foodTruckArray[]) { //calls FoodTruck constructor, uses FoodTruck setters and adds FoodTruck objects to foodTruckArray[] until full
		String holder = "";
		double rating = 0.0;

		for (int i = 0; i < foodTruckArray.length; i++) {

			if (foodTruckArray[4] != null) {
				System.out.println("Max number of food trucks already added. Returning to previous menu...");
				break;
			}
			else if (foodTruckArray[i] == null) {

				System.out.print(
						"Enter the name for food truck number " + (i + 1) + " or \"quit\" to return to main menu: ");
				holder = input.nextLine();

				if (holder.toLowerCase().equals("quit")) {
					System.out.println("Returning to previous menu...");
					break;
				}
				this.foodTruckArray[i] = new FoodTruck(holder);

				System.out.print("Enter this trucks food type: ");
				holder = input.nextLine();
				foodTruckArray[i].setFoodType(holder);

				System.out.print("Enter this trucks numeric rating: ");
				rating = input.nextDouble();
				input.nextLine();
				foodTruckArray[i].setRating(rating);

			}
		}
	}
	
	private void truckPrinter(FoodTruck foodTruckArray[]) { //calls toString() on all valid FoodTruck objects 

		if (foodTruckArray[0] == null) {
			System.out.println("No trucks found");
		} 
		
		else {
			for (int i = 0; i < foodTruckArray.length; i++) {

				if (foodTruckArray[i] != null) {
					System.out.println(foodTruckArray[i].toString());
				} else {
					break;
				}
			}
		}
	}
	
	private void getAverageRating(FoodTruck foodTruckArray[]) { //for calculating average of all FoodTruck objects double rating fields
		double divisor = 0.0;
		double ratingSum = 0.0;
		for (int i = 0; i < foodTruckArray.length; i++) {
			
			if (foodTruckArray[i] != null) {
				ratingSum += foodTruckArray[i].getRating();
				divisor += 1.0;
			} else {
				break;
			}
		}
		if (ratingSum == 0.0) { //prevents dividing by zero and returning NaN
			System.out.println("Combined average rating of all " + (int)(divisor) + " trucks is: 0");
		}
		else {
			System.out.println("Combined average rating of all trucks (" + (int)(divisor) + ") is: " + (ratingSum/divisor));
		}
	}
	
	public void showHighestRated(FoodTruck foodTruckArray[]) { //finds FoodTruck object with highest double rating field and calls toString()
		double highestRating = 0.0;
		int highestTruck = -1;
		for (int i = 0; i < foodTruckArray.length; i++) {
			
			if (foodTruckArray[i] != null && foodTruckArray[i].getRating() > highestRating) {
				highestRating = foodTruckArray[i].getRating();
				highestTruck = i;
				
			} 
		}
		if(highestTruck == -1) { //for disambiguation between empty array and array with one object
			System.out.println("No trucks found");
		}
		else {
			System.out.print("The highest rated truck is: ");
			System.out.println(foodTruckArray[highestTruck].toString());
		}
		
		
	}
	
	

}

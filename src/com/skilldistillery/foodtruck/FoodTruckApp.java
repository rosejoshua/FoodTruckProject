package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {

	private Scanner input = new Scanner(System.in);
	private FoodTruck foodTruckArray[] = new FoodTruck[5];

	public static void main(String[] args) {
		boolean run = true;
		int choice = 0;

		FoodTruckApp instance = new FoodTruckApp();

		while (run) {
			instance.printMenu();
			choice = instance.input.nextInt();
			instance.input.nextLine();
			if (choice < 1 && choice > 5) {
				System.out.println("invalid choice, try again");
			} else if (choice == 5) {
				System.out.println("Exiting program...");
				run = false;
			} else {
				instance.choiceHandler(choice, instance.foodTruckArray);
			}
		}

		instance.input.close();
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

	private void choiceHandler(int choice, FoodTruck foodTruckArray[]) {

		if (choice == 1) {
			arrayBuilder(choice, foodTruckArray);
		}

		else if (choice == 2) {
			truckPrinter(foodTruckArray);
		}
	}

	private void arrayBuilder(int choice, FoodTruck foodTruckArray[]) {
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
	
	private void truckPrinter(FoodTruck foodTruckArray[]) {
		for (int i = 0; i < foodTruckArray.length; i++) {

			if (foodTruckArray[i] != null) {
				foodTruckArray[i].toString();
			} else {
				break;
			}
		}
	}

}

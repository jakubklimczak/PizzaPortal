package com.pizzaportal;


import com.pizzaportal.model.*;
import com.pizzaportal.utils.FileHelper;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        List<Food> menuItems = FileHelper.loadFoodFromFile("snapshot1\\src\\main\\resources\\menu.txt");

        int i =1;
        for (Food item : menuItems) {

            System.out.println((i++) + ". " + item.getDescription());
        }

        while (true) {
            System.out.println("=== PizzaPortal Menu ===");
            System.out.println("1. View and choose items from menu.");
            System.out.println("2. Show order summary.");
            System.out.println("3. Save order to file.");
            System.out.println("0. Exit.");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Available menu items:");
                    int index = 1;

                    System.out.println("-- Meat Pizzas --");
                    for (Food item : menuItems) {
                        if (item instanceof MeatPizza) {
                            System.out.println((index++) + ". " + item.getDescription());
                        }
                    }

                    System.out.println("-- Vegetarian Pizzas --");
                    for (Food item : menuItems) {
                        if (item instanceof VegetarianPizza) {
                            System.out.println((index++) + ". " + item.getDescription());
                        }
                    }

                    System.out.println("-- Vegan Pizzas --");
                    for (Food item : menuItems) {
                        if (item instanceof VeganPizza) {
                            System.out.println((index++) + ". " + item.getDescription());
                        }
                    }

                    System.out.println("-- Side Dishes --");
                    for (Food item : menuItems) {
                        if (item instanceof SideDish) {
                            System.out.println((index++) + ". " + item.getDescription());
                        }
                    }

                    System.out.println("-- Sauces --");
                    for (Food item : menuItems) {
                        if (item instanceof Sauce) {
                            System.out.println((index++) + ". " + item.getDescription());
                        }
                    }

                    System.out.println("-- Drinks --");
                    for (Food item : menuItems) {
                        if (item instanceof Drink) {
                            System.out.println((index++) + ". " + item.getDescription());
                        }
                    }

                    System.out.print("Enter the number of the item you want to add to your order (0 to cancel): ");
                    int itemChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (itemChoice > 0 && itemChoice <= menuItems.size()) {
                        order.addItem(menuItems.get(itemChoice - 1));
                        System.out.println("Item added to order.");
                    } else if (itemChoice != 0) {
                        System.out.println("Invalid item number.");
                    }
                }
                case 2 -> {
                    System.out.println("Your order:");
                    order.getItems().forEach(p -> System.out.println(p.getDescription()));
                    System.out.println("Total price: " + order.calculateTotal() + " PLN");
                }
                case 3 -> FileHelper.saveOrderToFile(order);
                case 0 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }
}
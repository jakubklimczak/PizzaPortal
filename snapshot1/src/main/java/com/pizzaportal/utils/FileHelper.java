package com.pizzaportal.utils;

import com.pizzaportal.model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    public static void saveOrderToFile(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("snapshot1\\\\src\\\\main\\\\resources\\\\orders.txt", true))) {
            for (Food item : order.getItems()) {
                writer.write(item.getDescription());
                writer.newLine();
            }
            writer.write("Total: " + order.calculateTotal() + " PLN");
            writer.newLine();
            writer.write("-----");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Food> loadFoodFromFile(String filename) {
        List<Food> foodItems = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                String type = parts[0];
                String systemId = parts[1];
                double price = Double.parseDouble(parts[2]);

                switch (type.toLowerCase()) {
                    case "meatpizza" -> {
                        String name = parts[3];
                        int size = Integer.parseInt(parts[4]);
                        String[] ingredients = parts[5].split(",");
                        String[] meats = parts[6].split(",");
                        foodItems.add(new MeatPizza(systemId, name, price, size, ingredients, meats));
                    }
                    case "vegetarianpizza" -> {
                        String name = parts[3];
                        int size = Integer.parseInt(parts[4]);
                        String[] ingredients = parts[5].split(",");
                        boolean withCheese = Boolean.parseBoolean(parts[6]);
                        foodItems.add(new VegetarianPizza(systemId, name, price, size, ingredients, withCheese));
                    }
                    case "veganpizza" -> {
                        String name = parts[3];
                        int size = Integer.parseInt(parts[4]);
                        String[] ingredients = parts[5].split(",");
                        boolean glutenFree = Boolean.parseBoolean(parts[6]);
                        foodItems.add(new VeganPizza(systemId, name, price, size, ingredients, glutenFree));
                    }
                    case "drink" -> {
                        int volume = Integer.parseInt(parts[3]);
                        boolean alcoholic = Boolean.parseBoolean(parts[4]);
                        String name = parts[5];
                        foodItems.add(new Drink(systemId, price, volume, alcoholic, name));
                    }
                    case "sauce" -> {
                        String flavor = parts[3];
                        foodItems.add(new Sauce(systemId, price, flavor));
                    }
                    case "sidedish" -> {
                        String kind = parts[3];
                        String name = parts[4];
                        foodItems.add(new SideDish(systemId, price, kind, name));
                    }
                    default -> System.out.println("Unknown food type: " + type);
                }
            }
        } 
        catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        return foodItems;
    }

}
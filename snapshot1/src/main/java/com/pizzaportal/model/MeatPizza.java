package com.pizzaportal.model;

public class MeatPizza extends Pizza {
    private String[] meats;

    public MeatPizza(String systemId, String name, double price, int size, String[] ingredients, String[] meats) {
        super(systemId, name, price, size, ingredients);
        this.meats = meats;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ". Meats: " + String.join(", ", meats) + ".";
    }
}
package com.pizzaportal.model;

public abstract class Pizza extends Food {
    protected String name;
    protected int size;
    private String[] ingredients;

    public Pizza(String systemId, String name, double price, int size, String[] ingredients) {
        super(systemId, price);
        this.name = name;
        this.size = size;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String getDescription() {
        return name + " (" + size + "cm) - " + price + " PLN. Ingredients: " + String.join(", ", ingredients);
    }
}
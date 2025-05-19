package com.pizzaportal.model;

public class VegetarianPizza extends Pizza {
    private boolean includesCheese;

    public VegetarianPizza(String systemId, String name, double price, int size, String[] ingredients, boolean includesCheese) {
        super(systemId, name, price, size, ingredients);
        this.includesCheese = includesCheese;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + (includesCheese ? ". Includes cheese!" : " [No cheese.]");
    }
}
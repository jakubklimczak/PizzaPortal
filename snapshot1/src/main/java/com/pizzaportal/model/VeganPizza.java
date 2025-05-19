package com.pizzaportal.model;

public class VeganPizza extends Pizza {
    private boolean glutenFree;

    public VeganPizza(String systemId, String name, double price, int size, String[] ingredients, boolean glutenFree) {
        super(systemId, name, price, size, ingredients);
        this.glutenFree = glutenFree;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + (glutenFree ? ". Gluten-free." : "");
    }
}
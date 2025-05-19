package com.pizzaportal.model;

public class Drink extends Food {
    private int volumeMl;
    private String name;
    private boolean alcoholic;

    public Drink(String systemId, double price, int volumeMl, boolean alcoholic, String name) {
        super(systemId, price);
        this.volumeMl = volumeMl;
        this.alcoholic = alcoholic;
        this.name = name;
    }

    @Override
    public String getDescription() {
        return "Drink " + name + " (" + volumeMl + "ml) - " + price + " PLN. " + (alcoholic ? "Contains alcohol!" : "");
    }
}

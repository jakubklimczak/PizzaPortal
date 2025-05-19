package com.pizzaportal.model;

public class Sauce extends Food {
    private String flavour;

    public Sauce(String systemId, double price, String flavour) {
        super(systemId, price);
        this.flavour = flavour;
    }

    @Override
    public String getDescription() {
        return "Sauce: " + flavour + " - " + price + " PLN";
    }
}
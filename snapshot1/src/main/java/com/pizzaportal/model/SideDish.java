package com.pizzaportal.model;

public class SideDish extends Food {
    private String type;
    private String name;

    public SideDish(String systemId, double price, String type, String name) {
        super(systemId, price);
        this.type = type;
        this.name = name;
    }

    @Override
    public String getDescription() {
        return type + ": " + name + " - " + price + " PLN.";
    }
}
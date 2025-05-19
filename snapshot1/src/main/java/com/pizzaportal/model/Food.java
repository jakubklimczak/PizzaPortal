package com.pizzaportal.model;

public abstract class Food {
    protected String systemId;
    protected double price;

    public Food(String systemId, double price) {
        this.systemId = systemId;
        this.price = price;
    }

    public String getSystemId() {
        return systemId;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getDescription();

    public void setPrice(double price) {
        this.price = price;
    }
}

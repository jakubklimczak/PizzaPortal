package com.pizzaportal.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Food> items = new ArrayList<>();

    public void addItem(Food item) {
        items.add(item);
    }

    public List<Food> getItems() {
        return items;
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(Food::getPrice).sum();
    }
}
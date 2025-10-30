package com.restaurant.manager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<String> menu;
    private double totalRevenue; 

    public Restaurant (String name) {
        this.name = name;
        this.menu = new ArrayList<>();
        this.totalRevenue = 0.0;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenu() {
        return new ArrayList<>(menu);
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
    
    public void processOrder(String item, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo");
        }
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("El item no puede estar vacío");
        }
        totalRevenue += price;
    }

    public int getOrderCount() {
        return (int) (totalRevenue / 10);
    }

    public void resetRevenue() {
        totalRevenue = 0.0;
    }
}
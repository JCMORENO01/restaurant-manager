package com.restaurant.manager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<String> menu;
    private double totalRevenue;
    private List<String> reservations;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
        this.totalRevenue = 0.0;
        this.reservations = new ArrayList<>();
    }

    // Métodos de reservas (de main)
    public void makeReservation(String customerName, int partySize, String dateTime) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente es requerido");
        }
        if (partySize <= 0) {
            throw new IllegalArgumentException("El tamaño del grupo debe ser positivo");
        }
        if (dateTime == null || dateTime.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha y hora son requeridas");
        }

        String reservation = String.format("%s - %d personas - %s",
            customerName.trim(), partySize, dateTime.trim());
        reservations.add(reservation);
    }

    public List<String> getReservations() {
        return new ArrayList<>(reservations);
    }

    public int getReservationCount() {
        return reservations.size();
    }

    public boolean cancelReservation(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            return false;
        }
        String trimmed = customerName.trim();
        return reservations.removeIf(res -> res.startsWith(trimmed));
    }

    // Métodos de menú y pedidos (de ambas ramas)
    public String getName() {
        return name;
    }

    public List<String> getMenu() {
        return new ArrayList<>(menu);
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void addMenuItem(String item) {
        if (item != null && !item.trim().isEmpty()) {
            menu.add(item.trim());
        }
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

    public void addRevenue(double amount) {
        if (amount > 0) {
            totalRevenue += amount;
        }
    }

    public int getOrderCount() {
        return (int) (totalRevenue / 10);
    }

    public void resetRevenue() {
        totalRevenue = 0.0;
    }
}

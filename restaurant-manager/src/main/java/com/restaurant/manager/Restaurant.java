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

    // ---------------------- RESERVAS ----------------------

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

    // ---------------------- ESTADÍSTICAS ----------------------

    /**
    * Calcula el valor promedio de las órdenes
    * @return promedio de ingresos por orden
    */
    public double getAverageOrderValue() {
        int orderCount = getOrderCount();
        if (orderCount == 0) {
            return 0.0;
        }
        return totalRevenue / orderCount;
    }

    /**
    * Verifica si el restaurante está generando buenos ingresos
    * @param threshold Umbral mínimo de ingresos
    * @return true si los ingresos superan el umbral
    */
    public boolean isPerformingWell(double threshold) {
        return totalRevenue >= threshold;
    }

    /**
    * Obtiene un resumen del estado del restaurante
    * @return String con estadísticas
    */
    public String getStatisticsSummary() {
        return String.format(
            "Restaurant: %s\n" +
            "Items en menú: %d\n" +
            "Reservas activas: %d\n" +
            "Órdenes procesadas: %d\n" +
            "Ingresos totales: $%.2f\n" +
            "Valor promedio por orden: $%.2f",
            name,
            menu.size(),
            reservations.size(),
            getOrderCount(),
            totalRevenue,
            getAverageOrderValue()
        );
    }

    // ---------------------- OTROS MÉTODOS ----------------------

    public String getName() {
        return name;
    }

    public List<String> getMenu() {
        return new ArrayList<>(menu);
    }

    public double getTotalRev


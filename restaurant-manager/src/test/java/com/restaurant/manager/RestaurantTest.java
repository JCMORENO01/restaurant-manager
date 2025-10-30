package com.restaurant.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de Restaurant")
public class RestaurantTest {
    private Restaurant restaurant;

    @BeforeEach
    public void setup() {
        restaurant = new Restaurant("La Pizzeria");
    }

    @Test
    @DisplayName("Test crear restaurante con nombre válido")
    public void testCreateRestaurant () {
        assertEquals("La Pizzeria", restaurant.getName());
        assertTrue(restaurant.getMenu().isEmpty());
        assertEquals (0.0, restaurant.getTotalRevenue(), 0.001);
    }

    @Test
    @DisplayName("Test procesar orden actualiza ingresos correctamente")
    public void testProcessorder() {
        restaurant.processOrder("Pizza Margherita", 12.99);
        assertEquals(12.99, restaurant.getTotalRevenue(), 0.01);
    }

    @Test
    @DisplayName("Test procesar múltiples órdenes suma ingresos")
    public void testProcessMultipleOrders() {
        restaurant.processOrder("Pizza", 12.99);
        restaurant.processOrder("Pasta", 10.99);
        restaurant.processOrder("Bebida", 3.50);
        assertEquals(27.48, restaurant.getTotalRevenue(), 0.01);
    }

    @Test
    @DisplayName("Test procesar orden con precio cero lanza excepción")
    public void testProcessOrderZeroPrice() {
        assertThrows(IllegalArgumentException.class,
            () -> restaurant.processOrder("Pizza", 0));
    }

    @Test
    @DisplayName("Test procesar orden con precio negativo lanza excepción")
    public void testProcessOrderNegativePrice() {
        assertThrows(IllegalArgumentException.class,
            () -> restaurant.processOrder("Pizza", -10.0));
    }

    @Test
    @DisplayName("Test procesar orden con item vacío lanza excepción")
    public void testProcessOrderEmptyItem() {
        assertThrows(IllegalArgumentException.class,
            () -> restaurant.processOrder("", 10.0));
    }

    @Test
    @DisplayName("Test contar órdenes procesadas")
    public void testGetOrderCount() {
        restaurant.processOrder("Orden 1", 10.0);
        restaurant.processOrder("Orden 2", 20.0);
        assertEquals(3, restaurant.getOrderCount());
    }

    @Test
    @DisplayName("Test resetear ingresos")
    public void testResetRevenue() {
        restaurant.processOrder("Pizza", 12.99);
        assertEquals(12.99, restaurant.getTotalRevenue(), 0.01);
        restaurant.resetRevenue();
        assertEquals(0.0, restaurant.getTotalRevenue(), 0.01);
    }
}
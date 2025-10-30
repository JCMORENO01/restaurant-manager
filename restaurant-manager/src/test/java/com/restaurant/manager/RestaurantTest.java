@Test
@DisplayName("Test calcular valor promedio de órdenes")
public void testGetAverageOrderValue() {
 restaurant.processOrder("Orden 1", 20.0);
 restaurant.processOrder("Orden 2", 30.0);

 // 50 total / 5 órdenes estimadas = 10
 double average = restaurant.getAverageOrderValue();
 assertEquals(10.0, average, 0.01);
}
@Test
@DisplayName("Test promedio con cero órdenes")
public void testGetAverageOrderValueNoOrders() {
 assertEquals(0.0, restaurant.getAverageOrderValue(), 0.01);
}
@Test
@DisplayName("Test verificar buen desempeño")
public void testIsPerformingWell() {
 restaurant.processOrder("Orden", 100.0);

 assertTrue(restaurant.isPerformingWell(50.0));
 assertFalse(restaurant.isPerformingWell(150.0));
}
@Test
@DisplayName("Test obtener resumen de estadísticas")
public void testGetStatisticsSummary() {
 restaurant.addMenuItem("Pizza", 12.99);
 restaurant.makeReservation("Juan", 4, "2024-12-25 19:00");
 restaurant.processOrder("Orden", 25.50);

 String summary = restaurant.getStatisticsSummary();

 assertNotNull(summary);
 assertTrue(summary.contains("La Pizzeria"));
 assertTrue(summary.contains("25.50"));
}

//Pruebas para verificar el valor promedio de ordenes, buen desempeño e informe estadístico

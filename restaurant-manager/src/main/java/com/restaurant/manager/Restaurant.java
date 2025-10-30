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
//Codigo de la clase Restaurant.java
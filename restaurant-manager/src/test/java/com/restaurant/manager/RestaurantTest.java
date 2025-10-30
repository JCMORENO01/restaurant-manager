import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Test
@DisplayName("Test crear reserva válida")
public void testMakeReservation() {
    restaurant.makeReservation("Juan Pérez", 4, "2024-12-25 19:00");
    assertEquals(1, restaurant.getReservationCount());
    List<String> reservations = restaurant.getReservations();
    assertTrue(reservations.get(0).contains("Juan Pérez"));
    assertTrue(reservations.get(0).contains("4 personas"));
}

@Test
@DisplayName("Test crear múltiples reservas")
public void testMakeMultipleReservations() {
    restaurant.makeReservation("Cliente 1", 2, "2024-12-25 18:00");
    restaurant.makeReservation("Cliente 2", 4, "2024-12-25 19:00");
    restaurant.makeReservation("Cliente 3", 6, "2024-12-25 20:00");
    assertEquals(3, restaurant.getReservationCount());
}

@Test
@DisplayName("Test crear reserva con nombre vacío lanza excepción")
public void testMakeReservationEmptyName() {
    assertThrows(IllegalArgumentException.class,
        () -> restaurant.makeReservation("", 4, "2024-12-25 19:00"));
}

@Test
@DisplayName("Test crear reserva con tamaño inválido lanza excepción")
public void testMakeReservationInvalidSize() {
    assertThrows(IllegalArgumentException.class,
        () -> restaurant.makeReservation("Juan", 0, "2024-12-25 19:00"));
    assertThrows(IllegalArgumentException.class,
        () -> restaurant.makeReservation("Juan", -2, "2024-12-25 19:00"));
}

@Test
@DisplayName("Test crear reserva sin fecha lanza excepción")
public void testMakeReservationNoDateTime() {
    assertThrows(IllegalArgumentException.class,
        () -> restaurant.makeReservation("Juan", 4, ""));
}

@Test
@DisplayName("Test cancelar reserva existente")
public void testCancelReservation() {

    restaurant.makeReservation("Juan Pérez", 4, "2024-12-25 19:00");
    restaurant.makeReservation("María López", 2, "2024-12-25 20:00");

    boolean cancelled = restaurant.cancelReservation("Juan Pérez");

    assertTrue(cancelled);
    assertEquals(1, restaurant.getReservationCount());
}

@Test
@DisplayName("Test cancelar reserva inexistente retorna false")
public void testCancelNonExistentReservation() {
    restaurant.makeReservation("Juan", 4, "2024-12-25 19:00");
    boolean cancelled = restaurant.cancelReservation("Pedro");
    assertFalse(cancelled);
    assertEquals(1, restaurant.getReservationCount());
}

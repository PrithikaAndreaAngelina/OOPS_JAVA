import java.util.Map;
import java.util.HashMap;

public class BusReservationSystem {
    private Map<String, Bus> buses = new HashMap<>();

    // Add a new bus route
    public void addBusRoute(String route, int totalSeats) {
        buses.put(route, new Bus(route, totalSeats));
    }

    // Reserve a seat on a bus route
    public boolean reserveSeat(String route, int seatNumber) {
        Bus bus = buses.get(route);
        if (bus == null) return false;  // If bus route not found
        return bus.reserveSeat(seatNumber);
    }

    // Cancel a reservation
    public void cancelReservation(String route, int seatNumber) {
        Bus bus = buses.get(route);
        if (bus != null) {
            bus.cancelReservation(seatNumber);
        }
    }

    // Show available seats on a bus route
    public void displayAvailableSeats(String route) {
        Bus bus = buses.get(route);
        if (bus != null) {
            bus.displayAvailableSeats();
        }
    }
}

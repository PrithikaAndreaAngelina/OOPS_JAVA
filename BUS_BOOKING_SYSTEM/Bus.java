import java.util.ArrayList;
import java.util.List;

public class Bus {
    private String route;
    private int totalSeats;
    private List<Boolean> availableSeats;

    public Bus(String route, int totalSeats) {
        this.route = route;
        this.totalSeats = totalSeats;
        this.availableSeats = new ArrayList<>(totalSeats);
        for (int i = 0; i < totalSeats; i++) {
            availableSeats.add(true);  // All seats are initially available (true = available)
        }
    }

    public String getRoute() {
        return route;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public boolean isSeatAvailable(int seatNumber) {
        if (seatNumber < 1 || seatNumber > totalSeats) {
            return false;
        }
        return availableSeats.get(seatNumber - 1);
    }

    public boolean reserveSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > totalSeats) {
            return false;
        }
        if (availableSeats.get(seatNumber - 1)) {
            availableSeats.set(seatNumber - 1, false); // Mark the seat as reserved
            return true;
        }
        return false;
    }

    public void cancelReservation(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= totalSeats) {
            availableSeats.set(seatNumber - 1, true); // Mark the seat as available
        }
    }

    public void displayAvailableSeats() {
        System.out.println("Available seats for route " + route + ":");
        for (int i = 0; i < totalSeats; i++) {
            if (availableSeats.get(i)) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
}

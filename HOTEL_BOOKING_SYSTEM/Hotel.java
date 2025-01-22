import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String hotelName;
    private int totalRooms;
    private List<Boolean> availableRooms;

    // Constructor to initialize hotel with name and total rooms
    public Hotel(String hotelName, int totalRooms) {
        this.hotelName = hotelName;
        this.totalRooms = totalRooms;
        this.availableRooms = new ArrayList<>(totalRooms);
        for (int i = 0; i < totalRooms; i++) {
            availableRooms.add(true);  // All rooms are initially available (true = available)
        }
    }

    // Getter for hotel name
    public String getHotelName() {
        return hotelName;
    }

    // Getter for total rooms in the hotel
    public int getTotalRooms() {
        return totalRooms;
    }

    // Method to check if a room is available
    public boolean isRoomAvailable(int roomNumber) {
        if (roomNumber < 1 || roomNumber > totalRooms) {
            return false;  // Invalid room number
        }
        return availableRooms.get(roomNumber - 1);  // Returns true if room is available
    }

    // Method to reserve a room
    public boolean reserveRoom(int roomNumber) {
        if (roomNumber < 1 || roomNumber > totalRooms) {
            return false;  // Invalid room number
        }
        if (availableRooms.get(roomNumber - 1)) {
            availableRooms.set(roomNumber - 1, false); // Mark the room as reserved
            return true;
        }
        return false;  // Room is already reserved
    }

    // Method to cancel a reservation for a room
    public void cancelReservation(int roomNumber) {
        if (roomNumber >= 1 && roomNumber <= totalRooms) {
            availableRooms.set(roomNumber - 1, true); // Mark the room as available again
        }
    }

    // Method to display available rooms
    public void displayAvailableRooms() {
        System.out.println("Available rooms in hotel " + hotelName + ":");
        for (int i = 0; i < totalRooms; i++) {
            if (availableRooms.get(i)) {
                System.out.print((i + 1) + " ");  // Display room numbers starting from 1
            }
        }
        System.out.println();  // Move to the next line after displaying room numbers
    }
}

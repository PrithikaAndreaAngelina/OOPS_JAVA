import java.util.Scanner;

public class HotelReservationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelReservationSystem reservationSystem = new HotelReservationSystem();

        // Adding hotel rooms (for example, 10 rooms in Hotel1 and 15 rooms in Hotel2)
        reservationSystem.addHotel("Hotel1", 10); // 10 rooms for Hotel1
        reservationSystem.addHotel("Hotel2", 15); // 15 rooms for Hotel2

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Reserve Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter hotel name (Hotel1 / Hotel2): ");
                String hotelName = scanner.next();
                reservationSystem.displayAvailableRooms(hotelName);

            } else if (choice == 2) {
                System.out.print("Enter hotel name (Hotel1 / Hotel2): ");
                String hotelName = scanner.next();
                System.out.print("Enter room number: ");
                int roomNumber = scanner.nextInt();
                if (reservationSystem.reserveRoom(hotelName, roomNumber)) {
                    System.out.println("Room " + roomNumber + " reserved successfully at " + hotelName);
                } else {
                    System.out.println("Failed to reserve room " + roomNumber + " at " + hotelName);
                }

            } else if (choice == 3) {
                System.out.print("Enter hotel name (Hotel1 / Hotel2): ");
                String hotelName = scanner.next();
                System.out.print("Enter room number: ");
                int roomNumber = scanner.nextInt();
                reservationSystem.cancelReservation(hotelName, roomNumber);
                System.out.println("Reservation for room " + roomNumber + " canceled at " + hotelName);

            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

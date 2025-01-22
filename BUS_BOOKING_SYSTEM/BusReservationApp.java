import java.util.Scanner;

public class BusReservationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BusReservationSystem reservationSystem = new BusReservationSystem();

        // Adding bus routes
        reservationSystem.addBusRoute("Route1", 10); // 10 seats for Route1
        reservationSystem.addBusRoute("Route2", 15); // 15 seats for Route2

        while (true) {
            System.out.println("\nBus Reservation System");
            System.out.println("1. Display Available Seats");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter route (Route1 / Route2): ");
                String route = scanner.next();
                reservationSystem.displayAvailableSeats(route);

            } else if (choice == 2) {
                System.out.print("Enter route (Route1 / Route2): ");
                String route = scanner.next();
                System.out.print("Enter seat number: ");
                int seatNumber = scanner.nextInt();
                if (reservationSystem.reserveSeat(route, seatNumber)) {
                    System.out.println("Seat " + seatNumber + " reserved successfully on " + route);
                } else {
                    System.out.println("Failed to reserve seat " + seatNumber);
                }

            } else if (choice == 3) {
                System.out.print("Enter route (Route1 / Route2): ");
                String route = scanner.next();
                System.out.print("Enter seat number: ");
                int seatNumber = scanner.nextInt();
                reservationSystem.cancelReservation(route, seatNumber);
                System.out.println("Reservation for seat " + seatNumber + " canceled on " + route);

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

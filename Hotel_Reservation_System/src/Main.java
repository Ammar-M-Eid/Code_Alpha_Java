
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class Main {

    @SuppressWarnings("unused")
    public static void main(String[] args) throws Exception {
        Hotel hotel = createSampleHotel();
        ResManagement resManagement = new ResManagement(hotel);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to " + hotel.getName());
            System.out.println("Please enter your details to get started.");
            int guestId = Guest.generateGuestId();
            System.out.println("Enter name: ");
            String guestName = scanner.nextLine();
            System.out.println("Enter email: ");
            String guestEmail = scanner.nextLine();
            System.out.println("Enter phone number: ");
            String guestPhone = scanner.nextLine();
            Guest guest = new Guest(guestId, guestName, guestEmail, guestPhone);
            System.out.println("Generated guest ID: " + guestId);

            while (true) {
                System.out.println("1. Search available rooms");
                System.out.println("2. Make a reservation");
                System.out.println("3. View booking details");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> {
                        try {
                            System.out.println("Enter check-in date (YYYY-MM-DD): ");
                            LocalDate checkInDate = LocalDate.parse(scanner.nextLine());
                            System.out.println("Enter check-out date (YYYY-MM-DD): ");
                            LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());
                            if (checkOutDate.isBefore(checkInDate)) {
                                System.out.println("Check-out date must be after check-in date.");
                                continue;
                            }
                            List<Room> availableRooms = resManagement.searchAvailableRooms(checkInDate, checkOutDate);
                            System.out.println("Available rooms:");
                            for (Room room : availableRooms) {
                                System.out.println("Room " + room.getRoomNumber() + " - " + room.getRoomNumber() + " - $" + room.getPrice());
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                        }
                    }
                    case 2 -> {
                        try {
                            System.out.println("Enter check-in date (YYYY-MM-DD): ");
                            LocalDate checkInDate = LocalDate.parse(scanner.nextLine());
                            System.out.println("Enter check-out date (YYYY-MM-DD): ");
                            LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());
                            if (checkOutDate.isBefore(checkInDate)) {
                                System.out.println("Check-out date must be after check-in date.");
                                continue;
                            }
                            List<Room> availableRooms = resManagement.searchAvailableRooms(checkInDate, checkOutDate);
                            System.out.println("Available rooms:");
                            for (Room room : availableRooms) {
                                System.out.println("Room " + room.getRoomNumber() + " - " + room.getRoomNumber() + " - $" + room.getPrice());
                            }
                            System.out.print("Enter room number to reserve: ");
                            int roomNumber = Integer.parseInt(scanner.nextLine());
                            Room room = hotel.getRoomByNumber(roomNumber);
                            if (room != null) {
                                long daysBetween = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
                                double totalPrice = room.getPrice() * daysBetween;
                                Reservation reservation = resManagement.makeReservation(guest, room, checkInDate, checkOutDate);
                                System.out.println("Reservation made for " + guest.getName() + " in room " + room.getRoomNumber() + " with reservation ID: " + reservation.getId());
                                System.out.println("Total price: $" + totalPrice);
                            } else {
                                System.out.println("Invalid room number.");
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                        }
                    }
                    case 3 -> {
                        System.out.println("Enter reservation ID: ");
                        int reservationId = Integer.parseInt(scanner.nextLine());
                        Reservation reservation = resManagement.getReservationById(reservationId);
                        if (reservation != null) {
                            System.out.println("Reservation details:");
                            System.out.println("Guest: " + reservation.getGuest().getName());
                            System.out.println("Room: " + reservation.getRoom().getRoomNumber());
                            System.out.println("Check-in date: " + reservation.getCheckInDate());
                            System.out.println("Check-out date: " + reservation.getCheckOutDate());
                        } else {
                            System.out.println("Reservation not found.");
                        }
                    }
                    case 4 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default ->
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static Hotel createSampleHotel() {
        return new Hotel("HHOGWARTS Hotel", "CAIRO", List.of(
                new Room(101, RoomType.SINGLE, 100.0, true),
                new Room(102, RoomType.DOUBLE, 150.0, true),
                new Room(103, RoomType.SUITE, 200.0, true)
        ));
    }
}


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResManagement {

    private final Hotel hotel;
    private final List<Reservation> reservations;
    private int nextReservationId; 

    public ResManagement(Hotel hotel) {
        this.hotel = hotel;
        this.reservations = new ArrayList<>();
        this.nextReservationId = 1;
    }

    public List<Room> searchAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : hotel.getRooms()) {
            if (isRoomAvailable(room, checkInDate, checkOutDate)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    private boolean isRoomAvailable(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().equals(room)
                    && reservation.getCheckInDate().isBefore(checkOutDate)
                    && reservation.getCheckOutDate().isAfter(checkInDate)) {
                return false;
            }
        }
        return true;
    }

    public Reservation getReservationById(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }

    public Reservation makeReservation(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        Reservation reservation = new Reservation(nextReservationId++, guest, room, checkInDate, checkOutDate); 
        reservations.add(reservation);
        return reservation;
    }

    public void cancelReservation(Reservation reservation) {
        reservation.getRoom().setAvailable(true);
        reservations.remove(reservation); 
    }
}

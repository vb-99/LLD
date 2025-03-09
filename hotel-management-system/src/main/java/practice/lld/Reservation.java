package practice.lld;

import java.time.LocalDate;

public class Reservation {
    private final String reservationId;
    private final Guest guest;
    private final Room room;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;
    private ReservationStatus status;

    public Reservation(String reservationId, Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = ReservationStatus.CONFIRMED;
    }
    public synchronized void cancelReservation() {
        if(ReservationStatus.CONFIRMED == status) {
            status = ReservationStatus.CANCELLED;
        } else{
            throw new IllegalArgumentException("Reservation has already been cancelled");
        }

    }

    public Guest getGuest() {
        return guest;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }
}

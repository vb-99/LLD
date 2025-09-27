package com.example;

import java.util.List;

public class Reservation {
    private String reservationId;
    private User user;
    private Flight flight;
    private List<Seat> bookedSeats;
    private ReservationStatus status;

    public Reservation(Flight flight, String reservationId, User user, List<Seat> bookedSeats) {
        this.flight = flight;
        this.reservationId = reservationId;
        this.user = user;
        this.bookedSeats = bookedSeats;
        this.status = ReservationStatus.PENDING;

    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}

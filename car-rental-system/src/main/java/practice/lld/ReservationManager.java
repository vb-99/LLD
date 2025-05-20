package practice.lld;

import practice.lld.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ReservationManager {
    private Map<Integer,Reservation> reservations;

    public ReservationManager() {
        reservations = new HashMap<>();
    }
    public Reservation addReservation(int id, RentalStore rentalStore, User user, Vehicle vehicle, LocalDate startDate, LocalDate endDate){
        Reservation reservation = new Reservation(id,rentalStore,user,vehicle,startDate,endDate);
        reservations.put(reservation.getId(),reservation);
        user.addReservation(reservation);
        return reservation;
    }
    public void removeReservation(Integer reservationId){
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null) {
            reservation.cancelReservation();
        }
    }
    public void cancelReservation(Integer reservationId){
        Reservation reservation = reservations.get(reservationId);
        if(reservation == null) return;
        reservations.get(reservation.getId()).cancelReservation();
        removeReservation(reservationId);
    }

    public void confirmReservation(int reservationId){
        Reservation reservation = reservations.get(reservationId);
        if(reservation == null) return;
        reservation.confirmReservation();
    }
    public void startRental(int reservationId){
        Reservation reservation = reservations.get(reservationId);
        if(reservation == null) return;
        reservation.startRental();
    }
    public void endRental(int reservationId){
        Reservation reservation = reservations.get(reservationId);
        if(reservation == null) return;
        reservation.endRental();
        removeReservation(reservationId);

    }
}

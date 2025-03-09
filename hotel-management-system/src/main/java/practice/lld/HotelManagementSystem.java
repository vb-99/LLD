package practice.lld;

import practice.lld.payment.Payment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HotelManagementSystem {
    private static HotelManagementSystem instance;
    private final Map<String,Guest> guests;
    private final Map<String,Room> rooms;
    private final Map<String,Reservation>reservations;

    private HotelManagementSystem() {
        guests = new HashMap<>();
        rooms = new HashMap<>();
        reservations = new HashMap<>();
    }

    public static HotelManagementSystem getInstance() {
        if (instance == null) {
            instance = new HotelManagementSystem();
        }
        return instance;
    }

    public Guest getGuest(String id) {
        return guests.get(id);
    }

    public Room getRoom(String id) {
        return rooms.get(id);
    }

    public void addGuest(Guest guest) {
        guests.put(guest.getId(), guest);
    }

    public void addRoom(Room room) {
        rooms.put(room.getRoomId(), room);
    }

    private String generateReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8);
    }

    public synchronized Reservation makeReservation(Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) {
        if(room.getRoomStatus() == RoomStatus.AVAILABLE){
            room.book();
            Reservation reservation = new Reservation(generateReservationId(),guest,room,checkIn,checkOut);
            reservations.put(reservation.getReservationId(), reservation);
            return reservation;
        }
        return null;
    }
    public synchronized void cancelReservation(String reservationId){
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null && reservation.getStatus() == ReservationStatus.CONFIRMED){
            reservations.remove(reservationId);
            reservation.cancelReservation();
        } else{
            throw new IllegalArgumentException("Reservation cannot be cancelled");
        }
    }

    public synchronized void checkIn(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null && reservation.getStatus() == ReservationStatus.CONFIRMED){
           reservation.getRoom().checkIn();
        } else{
            throw new IllegalArgumentException("Reservation cannot be checked out");
        }
    }

    public synchronized void checkOut(String reservationId,Payment payment) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null && reservation.getStatus() == ReservationStatus.CONFIRMED){
           Room room = reservation.getRoom();
           double amount = room.getPrice()* ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
           if(payment.processPayment(amount)){
               room.checkOut();
               reservations.remove(reservationId);
           } else{
               throw new IllegalStateException("Payment cannot be checked out");
           }

        } else{
            throw new IllegalStateException("Reservation cannot be checked out");
        }
    }





}

package com.example;

import com.example.payment.CardPaymentStrategy;
import com.example.payment.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class AirlineManagementSystem {
    private static AirlineManagementSystem instance;
    private List<Flight> flights;
    private List<Reservation> reservations;
    private PaymentStrategy paymentStrategy;

    private AirlineManagementSystem(AirlineManagementSystem instance) {
       this.flights = new ArrayList<>();
       this.paymentStrategy = new CardPaymentStrategy();
       this.reservations = new ArrayList<>();
    }
    public static AirlineManagementSystem getInstance() {
        if(instance == null) {
            instance = new AirlineManagementSystem(null);
        }
        return instance;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public synchronized void createReservation(Reservation reservation){
            List<Seat>seatsToBook = reservation.getBookedSeats();
          Flight flight = reservation.getFlight();

          for(Seat seat : flight.getBookedSeats()){
              for(Seat bookedSeat : seatsToBook){
                  if(seat.equals(bookedSeat)){
                      throw new IllegalArgumentException("Seat already booked");
                  }
              }
          }
          double totalFare = reservation.getFlight().getPrice() * seatsToBook.size();
          if(paymentStrategy.makePayment(totalFare)){
              for(Seat seat:seatsToBook){
                  reservation.getFlight().addBookedSeat(seat);
              }
              reservation.setStatus(ReservationStatus.BOOKED);
              reservations.add(reservation);
              System.out.println("Reservation created successfully");
          } else{
              System.out.println("Payment cannot be processed");
          }

    }

    public void cancelReservation(Reservation reservation){
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservations.remove(reservation);
        System.out.println("Reservation Cancelled");
    }

    public void cancelFlight(Flight flight){
        for(Reservation reservation: reservations){
            if(reservation.getFlight().equals(flight)){
                reservation.setStatus(ReservationStatus.CANCELLED);
                flight.notifyObservers("Flight has been cancelled");
                System.out.println("Flight Cancelled");
                reservations.remove(reservation);
            }
        }
    }



}

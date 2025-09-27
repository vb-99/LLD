package com.example;


import com.example.observer.UserObserver;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Get system instance
        AirlineManagementSystem system = AirlineManagementSystem.getInstance();

        // ==== Create airports ====
        Airport delhi = new Airport("DEL", "Indira Gandhi International Airport", "Delhi");
        Airport mumbai = new Airport("BOM", "Chhatrapati Shivaji International Airport", "Mumbai");

        // ==== Create airplane ====
        Airplane boeing737 = new Airplane("AI101", "Boeing");

        // ==== Create flight ====
        Flight flight1 = new Flight("AI-2025", delhi, mumbai, LocalDateTime.now(), LocalDateTime.now().plusHours(2), 3000,boeing737);
        system.addFlight(flight1);

        // ==== Create users ====
        User user1 = new User("Alice", "123456","alice@email.com");
        User user2 = new User("Bob", "12345","bob@email.com");

        // Register users as observers for flight updates
        UserObserver obs1 = new UserObserver();
        UserObserver obs2 = new UserObserver();
        flight1.addObserver(obs1);
        flight1.addObserver(obs2);

        // ==== Book seats ====
        Seat seat1 = new Seat("A", 1);
        Seat seat2 = new Seat("B",1 );

        Reservation res1 = new Reservation(flight1,"1123",user1, List.of(seat1));
        Reservation res2 = new Reservation(flight1,"1124",user2, List.of(seat2));

        System.out.println("\n--- Reservations Created ---");
      system.createReservation(res1);
      system.createReservation(res2);

        // ==== Try duplicate seat booking ====
        System.out.println("\n--- Duplicate Booking Attempt ---");
        //system.createReservation(res1);

        // ==== Cancel one reservation ====
        System.out.println("\n--- Cancelling Reservation ---");
        system.cancelReservation(res1);

        // ==== Cancel whole flight (should notify observers) ====
        System.out.println("\n--- Cancelling Flight ---");
        system.cancelFlight(flight1);

    }
}
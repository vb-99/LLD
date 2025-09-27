package com.example;

import com.example.observer.ObserverInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightId;
    private Airport source;
    private Airport destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private List<Seat> bookedSeats;
    private List<Seat> boardedSeats;
    private double price;
    private List<ObserverInterface> observers;
    private Airplane airplane;

    public Flight(String flightId, Airport source, Airport destination, LocalDateTime departureTime, LocalDateTime arrivalTime, double price, Airplane airplane) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.bookedSeats = new ArrayList<>();
        this.boardedSeats = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.airplane = airplane;
    }
    public String getFlightId() {
        return flightId;
    }
    public Airport getSource() {
        return source;
    }
    public Airport getDestination() {
        return destination;
    }
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }
    public double getPrice() {
        return price;
    }
    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }
    public List<Seat> getBoardedSeats() {
        return boardedSeats;
    }
    public void addBookedSeat(Seat seat){
        bookedSeats.add(seat);
    }
    public void addBoardedSeat(Seat seat){
        boardedSeats.add(seat);
    }
    public void removeBookedSeat(Seat seat){
        bookedSeats.remove(seat);
    }
    public void removeBoardedSeat(Seat seat){
        boardedSeats.remove(seat);
    }
    public void addObserver(ObserverInterface observer){
        observers.add(observer);
    }
    public void removeObserver(ObserverInterface observer){
        observers.remove(observer);
    }

    public void notifyObservers(String message){
        for(ObserverInterface observer : observers){
            observer.notifyObservers(message);
        }
    }

}

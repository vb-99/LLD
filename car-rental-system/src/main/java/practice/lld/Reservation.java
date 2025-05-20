package practice.lld;

import practice.lld.enums.ReservationStatus;
import practice.lld.enums.VehicleStatus;
import practice.lld.vehicle.Vehicle;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private int id;
    private RentalStore rentalStore;
    private User user;
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;
    private ReservationStatus status;
    private double price;

    public Reservation(int id, RentalStore rentalStore, User user, Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.rentalStore = rentalStore;
        this.user = user;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = ReservationStatus.PROCESSING;
        this.price = vehicle.getRentalPrice((int)ChronoUnit.DAYS.between(startDate, endDate));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RentalStore getRentalStore() {
        return rentalStore;
    }

    public void setRentalStore(RentalStore rentalStore) {
        this.rentalStore = rentalStore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void confirmReservation(){
        if(this.status == ReservationStatus.PROCESSING) {
            this.status = ReservationStatus.CONFIRMED;
            vehicle.setVehicleStatus(VehicleStatus.BOOKED);
        }
    }
    public void cancelReservation(){
        if(this.status == ReservationStatus.PROCESSING || this.status == ReservationStatus.CONFIRMED){
            this.status = ReservationStatus.CANCELLED;
            vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
            user.removeReservation(this.id);
        }
    }
    public void startRental(){
        if(this.status == ReservationStatus.CONFIRMED){
            vehicle.setVehicleStatus(VehicleStatus.OCCUPIED);
            this.status = ReservationStatus.IN_PROGRESS;
        }
    }
    public void endRental(){
        if(this.status == ReservationStatus.IN_PROGRESS){
            vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
            this.status = ReservationStatus.COMPLETED;
            user.removeReservation(this.id);
        }
    }
}

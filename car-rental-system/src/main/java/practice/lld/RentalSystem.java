package practice.lld;

import practice.lld.payment.CreditCardPaymentProcessor;
import practice.lld.payment.PaymentProcessor;
import practice.lld.vehicle.Vehicle;
import practice.lld.vehicle.VehicleFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalSystem {
    private static RentalSystem instance;
    private List<RentalStore> rentalStoreList;
    private VehicleFactory vehicleFactory;
    private ReservationManager reservationManager;
    private PaymentProcessor paymentProcessor;
    private Map<String,User> userMap;

    private RentalSystem() {
        this.rentalStoreList = new ArrayList<>();
        this.vehicleFactory = new VehicleFactory();
        this.reservationManager = new ReservationManager();
        this.paymentProcessor = new CreditCardPaymentProcessor();
        this.userMap = new HashMap<>();
    }

    public static synchronized RentalSystem getInstance() {
        if(instance == null) {
            instance = new RentalSystem();
        }
        return instance;
    }
    public void addRentalStore(RentalStore rentalStore) {
        rentalStoreList.add(rentalStore);
    }
    public void removeRentalStore(RentalStore rentalStore) {
        rentalStoreList.remove(rentalStore);
    }
    public User addUser(String driversLicense, String name, String email) {
        User user = new User(driversLicense,name,email);
        userMap.put(user.getDriversLicense(),user);
        return user;
    }
    public void removeUser(String driversLicense) {
        userMap.remove(driversLicense);
    }

    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
    public Reservation createReservation(int id, RentalStore rentalStore, User user, Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        return reservationManager.addReservation(id,rentalStore,user,vehicle,startDate,endDate);
    }
    public void cancelReservation(int reservationId) {
        reservationManager.cancelReservation(reservationId);
    }
    public void confirmReservation(int reservationId) {
        reservationManager.confirmReservation(reservationId);
    }
    public void startRental(int reservationId) {
        reservationManager.startRental(reservationId);
    }
    public void endRental(int reservationId) {
        reservationManager.endRental(reservationId);
    }
    public PaymentProcessor getPaymentProcessor() {
        return paymentProcessor;
    }




}

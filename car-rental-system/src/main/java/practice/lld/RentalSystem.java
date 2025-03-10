package practice.lld;

import practice.lld.payment.CardPaymentProcessor;
import practice.lld.payment.PaymentProcessor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class RentalSystem {
    private static RentalSystem instance;
    private final Map<String,Car> cars;
    private final Map<String,Customer> customers;
    private final Map<String,Reservation> reservations;
    private PaymentProcessor paymentProcessor;

    private RentalSystem() {
        this.cars = new HashMap<>();
        this.customers = new HashMap<>();
        this.reservations = new HashMap<>();
        this.paymentProcessor = new CardPaymentProcessor();
    }

    public static synchronized RentalSystem getInstance() {
        if(instance == null) {
            instance = new RentalSystem();
        }
        return instance;
    }
    public void addCar(Car car) {
        cars.put(car.getLicensePlate(),car);
    }
    public void addCustomer(Customer customer) {
        customers.put(customer.getDriversLicenseNumber(),customer);
    }
    public void removeCar(String licensePlate) {
        cars.remove(licensePlate);
    }
    public void removeCustomer(Customer customer) {
        customers.remove(customer.getDriversLicenseNumber());
    }
    public List<Car> getCarList(String company, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> searchedCars = new ArrayList<>();
        for(Car car: cars.values()){
            if(car.isAvailable() && car.getCompany().equals(company) && car.getModel().equals(model)){
                if(isCarAvailable(car,startDate,endDate)){
                    searchedCars.add(car);
                }
            }
        }
        return searchedCars;
    }

    private boolean isCarAvailable(Car car,LocalDate startDate,LocalDate endDate){
        for(Reservation reservation: reservations.values()){
            if(reservation.getCar().equals(car)){
                if(startDate.isAfter(reservation.getStartDate()) || endDate.isBefore(reservation.getEndDate())){
                    return false;
                }
            }
        }
        return true;
    }

    public synchronized void makeReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        if(isCarAvailable(car,startDate,endDate)) {
            String reservationId = UUID.randomUUID().toString().substring(0, 8);
            Reservation reservation = new Reservation(car, customer, startDate, endDate, reservationId);
            if(paymentProcessor.processPayment(reservation.getTotalAmount())) {
                reservations.put(reservationId, reservation);
                System.out.println("Reservation successful. Reservation ID: " + reservation.getReservationId());
                car.setIsAvailable(false);
            } else{
                System.out.println("Payment failed. Reservation canceled.");
            }
        } else{
            throw new IllegalStateException("Car is not available");
        }
    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null) {
            reservations.remove(reservationId);
            reservation.getCar().setIsAvailable(true);
            System.out.println("Reservation canceled. Reservation ID: " + reservation.getReservationId());
        } else{
            throw new IllegalStateException("Reservation is not available");
        }
    }

    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
}

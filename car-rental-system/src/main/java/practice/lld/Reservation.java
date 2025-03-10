package practice.lld;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private final String reservationId;
    private final Car car;
    private final Customer customer;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Double totalAmount;

    public Reservation(Car car, Customer customer, LocalDate startDate, LocalDate endDate,String reservationId) {
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationId = reservationId;
        this.totalAmount = calculateTotalAmount() ;
    }
    private double calculateTotalAmount() {
        return (ChronoUnit.DAYS.between(startDate, endDate)+1*(car.getRentalPricePerDay()));
    }

    public String getReservationId() {
        return reservationId;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public Double getTotalAmount() {
        return totalAmount;
    }

}

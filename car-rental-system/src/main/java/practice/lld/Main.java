package practice.lld;

import practice.lld.enums.VehicleType;
import practice.lld.vehicle.Vehicle;
import practice.lld.vehicle.VehicleFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        RentalSystem rentalSystem = RentalSystem.getInstance();

        // Create rental stores
        RentalStore store1 = new RentalStore(
                1, "Downtown Rentals", new Address("123 Main St", "10001"));
        RentalStore store2 = new RentalStore(
                2, "Airport Rentals", new Address("456 Airport Rd", "90045"));
        rentalSystem.addRentalStore(store1);
        rentalSystem.addRentalStore(store2);

        // Create vehicles using Factory Pattern
        Vehicle economyCar = VehicleFactory.createVehicle(
                VehicleType.MINI, "EC001", "Toyota", "Corolla", 100);
        Vehicle luxuryCar = VehicleFactory.createVehicle(
                VehicleType.SEDAN, "LX001", "Mercedes", "S-Class", 200);
        Vehicle suvCar =
                VehicleFactory.createVehicle(VehicleType.SUV, "SV001", "Honda", "CR-V",  75.0);

        // Add vehicles to stores
        store1.addVehicle(economyCar);
        store1.addVehicle(luxuryCar);
        store2.addVehicle(suvCar);

        // Register user
        User user1 =
                rentalSystem.addUser("123-456-7890", "John Doe", "john@example.com");

        // Create reservations
        Reservation reservation1 =
                rentalSystem.createReservation(1, store1,user1, economyCar,LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 15));

        rentalSystem.getPaymentProcessor().processPayment(reservation1.getPrice());
    }
}
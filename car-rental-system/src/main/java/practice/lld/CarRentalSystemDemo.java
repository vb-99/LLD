package practice.lld;


import java.time.LocalDate;
import java.util.List;

public class CarRentalSystemDemo {
    public static void main(String[] args) {
        RentalSystem rentalSystem = RentalSystem.getInstance();

        // Add cars to the rental system
        rentalSystem.addCar(new Car("Toyota", "Camry", "2022", "ABC123", 50.0));
        rentalSystem.addCar(new Car("Honda", "Civic", "2021", "XYZ789", 45.0));
        rentalSystem.addCar(new Car("Ford", "Mustang", "2023", "DEF456", 80.0));

        // Create customers
        Customer customer1 = new Customer("John Doe", "john@example.com", "DL1234");

        // Make reservations
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);
        List<Car> availableCars = rentalSystem.getCarList("Toyota", "Camry", startDate, endDate);
        if (!availableCars.isEmpty()) {
            Car selectedCar = availableCars.getFirst();
            rentalSystem.makeReservation(customer1, selectedCar, startDate, endDate);
        } else {
            System.out.println("No available cars found for the given criteria.");
        }
    }
}

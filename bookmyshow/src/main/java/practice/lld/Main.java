package practice.lld;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        MovieController movieController = new MovieController();
        TheatreController theatreController = new TheatreController();
        BookingController bookingController = new BookingController();
        ShowController showController = new ShowController(bookingController, theatreController);
        PaymentStrategy paymentStrategy = new UpiPaymentStrategy();

        // Step 1: Create a theater
        System.out.println("Creating a new theatre...");
        int theatreId = theatreController.addTheatre(new Theatre(1, "PVR Cinemas"));
        System.out.println("Theatre created with ID: " + theatreId);
        // Step 2: Create a screen in the theater
        System.out.println("Creating a new screen...");
        int screenId = showController.addScreen(new Screen(1, "Screen 1", theatreId));
        System.out.println("Screen created with ID: " + screenId);

        // Step 3: Create seats in the screen
        System.out.println("Creating seats...");
        // Create 5 rows with 10 seats each
        for (int i = 1; i <= 50; i++) {
            SeatCategory category;
            int seatNumber = 1;
            if (i == 1) {
                category = SeatCategory.PLATINUM; // The first row is premium
            } else if (i <= 30) {
                category = SeatCategory.GOLD;
                //The next two rows are gold
            } else {
                category = SeatCategory.SILVER;
                // The rest are silver
            }
            theatreController.addSeat(new Seat(i, category), theatreId, screenId);
        }
        // Step 4: Create a movie
        System.out.println("nCreating a new movie...");
        int movieId = movieController.addMovie(new Movie(1, "Inception", 150));
        System.out.println("Movie created with ID: " + movieId);

        // Step 5: Create a show
        System.out.println("nCreating a new show...");
        LocalDateTime showTime = LocalDateTime.now(); // Current time
        Show show1 = showController.addShow(new Show(1, movieId, screenId, showTime, 150));
        System.out.println("Show created with ID: " + show1.getId());

        // Step 6: Get available seats for the show
        System.out.println("nChecking available seats...");
        List<Integer> availableSeats = showController.getAvailableSeatsForAShow(show1.getId());
        System.out.println("Available seats: " + availableSeats);

        // Step 7: Create a user
        System.out.println("nCreating a user...");
        User user = new User("John Doe", "john.doe@example.com");
        System.out.println("User created: " + user.getName() + " with email: " + user.getEmail());

        // Step 8: Book tickets sequentially
        System.out.println("nSequential booking of seats 1, 2, 3...");
        Seat seat1 = showController.getSeatById(show1.getId(), 1);
        Seat seat2 = showController.getSeatById(show1.getId(), 2);
        Seat seat3 = showController.getSeatById(show1.getId(), 3);
        Booking booking1 = bookingController.createBooking(show1, user, Arrays.asList(seat1, seat2, seat3));
        System.out.println("Booking created with ID: " + booking1.getId());

        // Step 9: Process payment for the booking
        System.out.println("nProcessing payment...");
        paymentStrategy.processPayment(booking1);
        System.out.println("Payment processed successfully!");

        // Step 10: Verify booking status
        System.out.println("nBooking status: " + booking1.getBookingStatus());

        // Step 11: Check available seats again after booking
        System.out.println("nChecking available seats after booking...");
        availableSeats = showController.getAvailableSeatsForAShow(show1.getId());
        System.out.println("Available seats: " + availableSeats);

        // ------------------------------
        // CONCURRENT BOOKING SIMULATION
        // ------------------------------
        System.out.println("nSimulating concurrent booking attempts...");
        Seat seat5 = showController.getSeatById(show1.getId(), 5);
        Seat seat6 = showController.getSeatById(show1.getId(), 6);
        Seat seat7 = showController.getSeatById(show1.getId(), 7);
        Seat seat8 = showController.getSeatById(show1.getId(), 8);
        Seat seat9 = showController.getSeatById(show1.getId(), 9);
        Seat seat10 = showController.getSeatById(show1.getId(), 10);
        Thread t1 = new Thread(() -> {
            try {
                // User 1 (John Doe) trying to book seats 5, 6, 7
                Booking bookingT1 = bookingController.createBooking(show1, user, Arrays.asList(seat5, seat6, seat7));
                System.out.println("User1 booking (seats 5,6,7) succeeded with Booking ID: " + bookingT1.getId());
                paymentStrategy.processPayment(bookingT1);
            } catch (Exception e) {
                System.err.println("User1 booking (seats 5,6,7) failed: " + e.getMessage());
            }
        },"thread1");
        Thread t2 = new Thread(() -> {
            try {
                // User 2 trying to book seats 7, 8, 9 (seat 7 overlaps with User1’s attempt)
                User user2 = new User("Jane Doe", "jane.doe@example.com");
                Booking bookingT2 = bookingController.createBooking(show1, user2, Arrays.asList(seat7, seat8, seat9,seat10));
                System.out.println("User2 booking (seats 7,8,9) succeeded with Booking ID: " + bookingT2.getId());
                paymentStrategy.processPayment(bookingT2);

            } catch (Exception e) {
                System.err.println("User2 booking (seats 7,8,9) failed: " + e.getMessage());
            }
        },"thread2");
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            // Final available seats after concurrent attempts
            System.out.println("nFinal available seats after concurrent booking attempts: " + showController.getAvailableSeatsForAShow(show1.getId()));
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();

        }
    }
}
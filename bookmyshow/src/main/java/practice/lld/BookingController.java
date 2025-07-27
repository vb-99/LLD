package practice.lld;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingController {
    private final List<Booking> bookings;
    private final SeatLockProvider seatLockProvider;
    private final AtomicInteger bookingIdGenerator;

    public BookingController() {
        this.seatLockProvider = new DeafultSeatLockProvider(600);
        bookings = new java.util.ArrayList<>();
        bookingIdGenerator = new AtomicInteger(0);
    }

    public List<Seat> getAllBookedSeatsForShow(Show show){
        List<Seat>bookedSeats = new ArrayList<>();
       bookings.stream().filter(booking -> booking.getShow().equals(show)).forEach(booking -> bookedSeats.addAll(booking.getBookedSeats()));
       return bookedSeats;
    }
    public boolean isSeatsValid(List<Seat> seats, Show show){
        List<Seat> bookedSeats = getAllBookedSeatsForShow(show);
        for(Seat seat:seats){
            if(bookedSeats.contains(seat)){
                return false;
            }
        }
        return true;
    }

    public Booking createBooking(Show show, User user, List<Seat> seats) throws Exception {
        try{
        if(isSeatsValid(seats,show)){
            seatLockProvider.lockSeats(show,user,seats);
            final int bookingId = bookingIdGenerator.incrementAndGet();
            Booking booking = new Booking(bookingId,seats,user,show);
            bookings.add(booking);
            return booking;
        } else{
            throw new Exception("Seats are already booked for the show");
        }
        } catch(Exception e){
          throw new Exception(e.getMessage());
        }
    }
}

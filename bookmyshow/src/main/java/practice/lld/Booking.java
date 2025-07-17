package practice.lld;

import java.util.List;

public class Booking {
    private final int id;
    private final List<Seat> bookedSeats;
    private final User user;
    private final Show show;
    private BookingStatus bookingStatus;

    public Booking(int id, List<Seat> bookedSeats, User user, Show show) {
        this.id = id;
        this.bookedSeats = bookedSeats;
        this.user = user;
        this.show = show;
        this.bookingStatus = BookingStatus.PENDING;
    }
    public int getId() {
        return id;
    }
    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }
    public User getUser() {
        return user;
    }
    public Show getShow() {
        return show;
    }
    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

}

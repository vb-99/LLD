package practice.lld;

public class UpiPaymentStrategy implements PaymentStrategy{

    @Override
    public void processPayment(Booking booking) {
        double amount = 0;
        for(Seat seat: booking.getBookedSeats()){
            amount += seat.getPrice();
        }
        System.out.println("Processing UPI payment of Rs." + amount);
        booking.setBookingStatus(BookingStatus.CONFIRMED);
    }
}

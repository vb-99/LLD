package practice.lld;

import java.util.List;

public interface SeatLockProvider {
    void lockSeats(Show show, User user, List<Seat> seats) throws Exception;
    void unlockSeats(Show show, User user, List<Seat> seats);
    boolean validateLock(Show show, User user, Seat seat);
    List<Seat> getLockedSeats(Show show, User user);
}

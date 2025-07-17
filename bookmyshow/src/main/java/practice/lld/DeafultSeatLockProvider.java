package practice.lld;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeafultSeatLockProvider implements SeatLockProvider{
    private final Integer lockTimeout;
    private final Map<Show,Map<Seat,SeatLock>> seatLocks;

    public DeafultSeatLockProvider(Integer lockTimeout) {
        this.lockTimeout = lockTimeout;
        seatLocks = new ConcurrentHashMap<>();
    }

    @Override
    public synchronized void lockSeats(Show show, User user, List<Seat> seats) throws Exception {
        Map<Seat,SeatLock> showSeatLocks =seatLocks.computeIfAbsent(show,k->new ConcurrentHashMap<>());;
        synchronized (showSeatLocks) {
            for(Seat seat: seats) {
                if(showSeatLocks.containsKey(seat)){
                    SeatLock existingLock = showSeatLocks.get(seat);
                    if(!existingLock.isExpired()){
                        throw new Exception("Seat is already locked with number: " + seat.getSeatNumber());
                    }
                }
            }
            for(Seat seat: seats){
                SeatLock lock = new SeatLock(seat,show,lockTimeout, LocalDateTime.now(),user);
                showSeatLocks.put(seat,lock);
            }
        }
    }

    @Override
    public void unlockSeats(Show show, User user, List<Seat> seats) {
        Map<Seat,SeatLock> showSeatLocks = seatLocks.get(show);
        synchronized (showSeatLocks) {
            for(Seat seat: seats){
                SeatLock existingLock = showSeatLocks.get(seat);
                if(existingLock!=null && existingLock.getLockedBy().equals(user)){
                    showSeatLocks.remove(seat);
                }
            }
        }
    }

    @Override
    public boolean validateLock(Show show, User user, Seat seat) {
        Map<Seat,SeatLock> showSeatLocks = seatLocks.get(show);
        if(showSeatLocks==null){
            return false;
        }
        SeatLock existingLock = showSeatLocks.get(seat);
        return existingLock!=null && existingLock.getLockedBy().equals(user) && !existingLock.isExpired();
    }

    @Override
    public List<Seat> getLockedSeats(Show show, User user) {
       List<Seat> lockedSeats = new ArrayList<>();
       Map<Seat,SeatLock> showSeatLocks = seatLocks.get(show);
       if(showSeatLocks==null){
           return lockedSeats;
       }
       for(Map.Entry<Seat,SeatLock> entry: showSeatLocks.entrySet()){
           SeatLock lock = entry.getValue();
           if(!lock.isExpired()){
             lockedSeats.add(entry.getKey());
           }
       }
       return lockedSeats;
    }
}

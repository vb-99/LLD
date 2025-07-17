package practice.lld;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class SeatLock {
    private Seat seat;
    private Show show;
    private int timeoutInSeconds;
    private LocalDateTime lockedAt;
    private User lockedBy;

    public SeatLock(Seat seat, Show show, int timeoutInSeconds, LocalDateTime lockedAt, User lockedBy) {
        this.seat = seat;
        this.show = show;
        this.timeoutInSeconds = timeoutInSeconds;
        this.lockedAt = lockedAt;
        this.lockedBy = lockedBy;
    }

    public Seat getSeat() {
        return seat;
    }
    public Show getShow() {
        return show;
    }
    public int getTimeoutInSeconds() {
        return timeoutInSeconds;
    }
    public LocalDateTime getLockedAt() {
        return lockedAt;
    }
    public User getLockedBy() {
        return lockedBy;
    }
    public boolean isExpired() {
        ZoneId zdt = ZoneId.systemDefault();
        Instant currentTime = Instant.now();
        return currentTime.isAfter(getLockedAt().atZone(zdt).plusSeconds(getTimeoutInSeconds()).toInstant());
    }

    @Override
    public String toString(){
        return "SeatLock{" +
                "seat=" + seat +
                ", show=" + show +
                ", timeoutInSeconds=" + timeoutInSeconds +
                ", lockedAt=" + lockedAt +
                ", lockedBy=" + lockedBy +
                '}';
    }
}

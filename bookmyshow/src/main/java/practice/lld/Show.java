package practice.lld;

import java.time.LocalDateTime;
import java.util.List;

public class Show {
    private int id;
    private int movieId;
    private final int screenId;
    private final LocalDateTime startTime;
    private final int duration;

    public Show(int id, int movieId, int screenId, LocalDateTime startTime, int duration) {
        this.id = id;
        this.movieId = movieId;
        this.screenId = screenId;
        this.startTime = startTime;
        this.duration = duration;
    }
    public int getId() {
        return id;
    }
    public int getMovieId() {
        return movieId;
    }
    public int getScreenId() {
        return screenId;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public int getDuration() {
        return duration;
    }


}

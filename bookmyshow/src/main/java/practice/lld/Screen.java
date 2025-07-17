package practice.lld;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final int id;
    private final String name;
    private final int theatreId;
    private List<Seat> seats;

    public Screen(int id, String name,int theatreId) {
        this.id = id;
        this.name = name;
        this.theatreId = theatreId;
        this.seats = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getTheatreId() {
        return theatreId;
    }

    public void addSeats(Seat seat){
        if(seats == null){
            return;
        }
        seats.add(seat);
    }
    public List<Seat> getSeats() {
        return seats;
    }

}

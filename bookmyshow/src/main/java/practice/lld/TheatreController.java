package practice.lld;

import java.util.ArrayList;
import java.util.List;

public class TheatreController {
    private final List<Theatre> theatres;

    public TheatreController() {
        this.theatres = new ArrayList<>();
    }

    public Screen getScreen(int theatreId,int screenId){
        Theatre theatre = theatres.stream().filter(item -> item.getId()==theatreId).findFirst().orElse(null);
        if(theatre!=null){
            return theatre.getScreen(screenId);
        }
        return null;
    }
    public Theatre getTheatre(int id){
        return theatres.stream().filter(item -> item.getId()==id).findFirst().orElse(null);
    }
    public int addTheatre(Theatre theatre){
        theatres.add(theatre);
        return theatre.getId();
    }

    public void addSeat(Seat seat,int theatreId,int screenId){
       Theatre theatre = theatres.stream().filter(item -> item.getId()==theatreId).findFirst().orElse(null);
       if(theatre!=null){
           theatre.getScreen(screenId).addSeats(seat);
       }
    }


}

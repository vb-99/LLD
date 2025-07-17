package practice.lld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ShowController {
    private final List<Show> shows;
    private final List<Screen> screens;
    private final BookingController bookingController;
    private final TheatreController theatreController;

    public ShowController(BookingController bookingController,TheatreController theatreController) {
        this.shows = new ArrayList<>();
        this.screens = new ArrayList<>();
        this.bookingController = bookingController;
        this.theatreController = theatreController;
    }

    public Show addShow(Show show) {
        shows.add(show);
        return show;
    }
    public List<Show> getShows() {
        return Collections.unmodifiableList(shows);
    }
    public void removeShow(Show show) {
        shows.remove(show);
    }
    public Show getShowForScreen(int id, int screenId) {
        return shows.stream().filter(show -> {
            return show.getScreenId() == screenId && show.getId() == id;
        }).findFirst().orElse(null);
    }

    public List<Integer> getAvailableSeatsForAShow(int showId){
            Show show = shows.stream().filter(item -> item.getId() == showId).findFirst().orElse(null);
            if(show==null){
                return new ArrayList<>();
            }
         Screen screen  = screens.stream().filter(item -> item.getId() == show.getScreenId()).findFirst().orElse(null);
         if(screen == null){
            return new ArrayList<>();
         }
         List<Seat> allSeats = screen.getSeats();
         List<Seat> bookedSeats = bookingController.getAllBookedSeatsForShow(show);
         allSeats.removeAll(bookedSeats);
         List<Integer>availableSeatIds = allSeats.stream().map(Seat::getSeatNumber).toList();
         return availableSeatIds;
    }
    public int addScreen(Screen screen) {
        screens.add(screen);
        theatreController.getTheatre(screen.getTheatreId()).addScreen(screen);
        return screen.getId();
    }

    public Seat getSeatById(int showId,int seatId){
        Show show = shows.stream().filter(item -> item.getId() == showId).findFirst().orElse(null);
        if(show==null){
            return null;
        }
        for(Screen screen:screens){
            if(screen.getId()==show.getScreenId()){
                return screen.getSeats().stream().filter(seat -> seat.getSeatNumber()==seatId).findFirst().orElse(null);
            }
        }
        return null ;
    }




}

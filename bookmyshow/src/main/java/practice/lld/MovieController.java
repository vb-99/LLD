package practice.lld;

import java.util.HashMap;
import java.util.Map;

public class MovieController {
    private final Map<Integer,Movie> movieList;

    public MovieController(){
        this.movieList= new HashMap<>();
    }
    public Movie getMovie(int id){
        return movieList.get(id);
    }
    public int addMovie(Movie movie){
        movieList.put(movie.getId(),movie);
        return movie.getId();
    }




}

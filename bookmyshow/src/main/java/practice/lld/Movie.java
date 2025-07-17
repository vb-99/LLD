package practice.lld;

public class Movie {
    private final int id;
    private final String name;
    private final int movieLengthInMinutes;

    public Movie(int id, String name, int movieLengthInMinutes) {
        this.id = id;
        this.name = name;
        this.movieLengthInMinutes = movieLengthInMinutes;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getMovieLengthInMinutes() {
        return movieLengthInMinutes;
    }


}

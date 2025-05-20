package practice.lld;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String driversLicense;
    private String name;
    private String email;
    private Map<Integer,Reservation> reservations;

    public User(String driversLicense, String name, String email) {
        this.driversLicense = driversLicense;
        this.name = name;
        this.email = email;
        this.reservations = new HashMap<>();
    }
    public String getDriversLicense() {
        return driversLicense;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void addReservation(Reservation reservation){
        reservations.put(reservation.getId(),reservation);
    }
    public void removeReservation(Integer reservationId){
        reservations.remove(reservationId);
    }

}

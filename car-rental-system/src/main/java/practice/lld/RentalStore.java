package practice.lld;

import practice.lld.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalStore {
    private int id;
    private String name;
    private Address address;
    private Map<String, Vehicle> vehicles;

    public RentalStore(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.vehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.getLicensePlate(), vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle.getLicensePlate());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Map<String, Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Map<String, Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}

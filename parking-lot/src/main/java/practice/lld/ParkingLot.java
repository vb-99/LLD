package practice.lld;

import practice.lld.models.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class ParkingLot {
    private List<ParkingLevel> parkingLevels;
    private static ParkingLot instance;

    private ParkingLot() {
        parkingLevels = new ArrayList<>();
    }
    public static ParkingLot getInstance() {
        if(instance == null){
            instance = new ParkingLot();
        }
        return instance;

    }

    public void addLevel(ParkingLevel level){
        parkingLevels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingLevel level : parkingLevels){
            if(level.parkVehicle(vehicle)){
                System.out.println("Vehicle parked!");
                return true;
            }
        }
        System.out.println("Vehicle cannot be parked!");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle){
        for(ParkingLevel level : parkingLevels){
            if(level.unparkVehicle(vehicle)){
                System.out.println("Vehicle unparked!");
                return true;
            }
        }
        System.out.println("Vehicle cannot be unparked!");
        return false;
    }
    public void displayAvailability() {
        for (ParkingLevel level : parkingLevels) {
            level.displayAvailability();
        }
    }

}

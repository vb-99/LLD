package practice.lld;

import practice.lld.models.Vehicle;
import practice.lld.models.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
    private int level;
    private List<ParkingSpot> parkingSpots;

    public ParkingLevel(int level,int capacity) {
        parkingSpots = new ArrayList<>(capacity);
        this.level = level;
        // Assign spots in ration of 50:40:10 for bikes, cars and trucks
        int numBikes=(int)(0.50*capacity);
        int numCars=(int)(0.40*capacity);
        for(int i=0;i<numBikes;i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }
        for(int i=numBikes;i<numCars;i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }
        for(int i=numCars;i<capacity;i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }
    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot parkingSpot: parkingSpots){
            if(vehicle.getVehicleType() == parkingSpot.getParkingType() && parkingSpot.isAvailable()){
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }
    public boolean unparkVehicle(Vehicle vehicle){
        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.getVehicle() == vehicle){
                parkingSpot.unParkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Parking Level: " + level);
        for(ParkingSpot parkingSpot: parkingSpots){
            Vehicle parkedVehicle = parkingSpot.getVehicle();
            System.out.println(parkingSpot.getParkingType() + " " + (parkedVehicle != null ? parkingSpot.getVehicle() : "Empty"));
        }
    }
}

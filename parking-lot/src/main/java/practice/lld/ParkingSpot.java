package practice.lld;

import practice.lld.models.Vehicle;
import practice.lld.models.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private Vehicle vehicle;
    private final VehicleType parkingType;

    public ParkingSpot(int spotNumber,VehicleType parkingType) {
        this.spotNumber = spotNumber;
        this.parkingType = parkingType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isAvailable() {
        return this.vehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
       if(isAvailable() && vehicle.getVehicleType() == parkingType) {
           this.vehicle = vehicle;
       } else{
           throw new IllegalArgumentException("Invalid Vehicle Type or Vehicle already parked");
       }
    }
    public void unParkVehicle(Vehicle vehicle) {
       if(this.vehicle == null){
           throw new IllegalArgumentException("No Vehicle is parked");
       } else{
           this.vehicle = null;
       }
    }

    public VehicleType getParkingType() {
        return parkingType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

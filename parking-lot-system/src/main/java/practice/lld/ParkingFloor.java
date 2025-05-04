package practice.lld;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private final List<ParkingSlot> parkingSlots;
    private final int floorNumber;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        parkingSlots = new ArrayList<>();
    }

    private int getFloorNumber() {
        return floorNumber;
    }

    public void addParkingSlot(ParkingSlot parkingSlot) {
        parkingSlots.add(parkingSlot);
    }

    public ParkingSlot findEmptyParkingSlot(Vehicle vehicle) {
        for (ParkingSlot parkingSlot : parkingSlots) {
            if(!parkingSlot.isOccupied() && parkingSlot.canParkVehicle(vehicle)){
                return parkingSlot;
            }
        }
        return null;
    }

    public void parkVehicle(Vehicle vehicle) {
        ParkingSlot parkingSlot = findEmptyParkingSlot(vehicle);
        if(parkingSlot != null){
            parkingSlot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully");
        } else{
            System.out.println("Vehicle could not park");
        }

    }
    public ParkingSlot vacate(Vehicle vehicle) {
        for(ParkingSlot parkingSlot : parkingSlots){
            if(parkingSlot.isOccupied() && parkingSlot.getVehicle().equals(vehicle)){
                parkingSlot.vacate();
                System.out.println("Vehicle vacated successfully");
                return parkingSlot;
            }
        }
        return null;
    }
    public ParkingSlot getParkingSlotById(int id) {
        for(ParkingSlot parkingSlot : parkingSlots){
            if(parkingSlot.getParkingLotId() == id){
                return parkingSlot;
            }
        }
        return null;
    }

}

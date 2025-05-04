package practice.lld;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public void addParkingFloor(ParkingFloor floor) {
        parkingFloors.add(floor);
    }

    public ParkingSlot findEmptyParkingSlot(Vehicle vehicle) {
        for (ParkingFloor parkingFloor : parkingFloors) {
            ParkingSlot parkingSlot = parkingFloor.findEmptyParkingSlot(vehicle);
           if(parkingSlot != null){
               return parkingSlot;
           }
        }
        return null;
    }

    public ParkingSlot parkVehicle(Vehicle vehicle) {
        ParkingSlot parkingSlot = findEmptyParkingSlot(vehicle);
        if(parkingSlot != null){
            parkingSlot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully");
            return parkingSlot;
        } else{
            System.out.println("Vehicle could not park");
            return null;
        }

    }
    public void vacate(Vehicle vehicle) {
        for(ParkingFloor parkingFloor : parkingFloors){
            ParkingSlot parkingSlotVacated = parkingFloor.vacate(vehicle);
        }
    }

    public ParkingSlot getParkingSlotById(int id) {
        for(ParkingFloor parkingFloor : parkingFloors){
           if(parkingFloor.getParkingSlotById(id) != null){
               return parkingFloor.getParkingSlotById(id);
           }
        }
        return null;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public static class ParkingLotBuilder{
        private List<ParkingFloor> parkingFloors = new ArrayList<>();

        public ParkingLotBuilder addParkingFloor(int floorNumber, int numberOfCarParkings,int numberOfBikeParkings,int numberOfTruckParkings) {
            ParkingFloor floor = new ParkingFloor(floorNumber);
            parkingFloors.add(floor);
            int offset = 0;
            for(int i=1;i<=numberOfBikeParkings;i++){
                floor.addParkingSlot(new ParkingSlot(i+offset,VehicleType.BIKE));
            }
            offset += numberOfCarParkings;
           for(int i=1;i<=numberOfCarParkings;i++){
               floor.addParkingSlot(new ParkingSlot(i + offset,VehicleType.CAR));
           }
           offset+=numberOfCarParkings;
           for(int i=1;i<=numberOfTruckParkings;i++){
               floor.addParkingSlot(new ParkingSlot(i + offset,VehicleType.TRUCK));
           }
            return this;
        }

        public ParkingLot build(){
            return new ParkingLot(parkingFloors);
        }


    }
}

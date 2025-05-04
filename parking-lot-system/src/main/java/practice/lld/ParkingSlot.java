package practice.lld;

public class ParkingSlot {
    private int parkingLotId;
    private Vehicle vehicle;
    private VehicleType slotType;

    public ParkingSlot(int parkingLotId, VehicleType slotType) {
        this.parkingLotId = parkingLotId;
        this.slotType = slotType;
    }

    public boolean isOccupied(){
        return vehicle != null;
    }

    public boolean canParkVehicle(Vehicle vehicle){
        if(!isOccupied()){
            return vehicle.getVehicleType().equals(slotType);
        }
        return false;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (canParkVehicle(vehicle)) {
            this.vehicle = vehicle;
        }
    }

    public void vacate () {
        if (isOccupied()) {
            this.vehicle = null;
        }
    }
    public int getParkingLotId() {
        return parkingLotId;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

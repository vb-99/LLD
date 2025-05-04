package practice.lld;

public class OtherVehicle extends Vehicle {
    public OtherVehicle(String licensePlate,ParkingFeesStrategy parkingFeesStrategy) {
        super(licensePlate,VehicleType.OTHER,parkingFeesStrategy);
    }
}

package practice.lld;

public class Truck extends Vehicle {
    public Truck(String licensePlate,ParkingFeesStrategy parkingFeesStrategy) {
        super(licensePlate,VehicleType.TRUCK,parkingFeesStrategy);
    }
}

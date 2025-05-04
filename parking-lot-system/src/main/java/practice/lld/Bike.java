package practice.lld;


public class Bike extends Vehicle {

    public Bike(String licensePlate,ParkingFeesStrategy parkingFeesStrategy) {
        super(licensePlate,VehicleType.BIKE,parkingFeesStrategy);
    }
}

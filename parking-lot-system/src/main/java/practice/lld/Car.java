package practice.lld;

public class Car extends Vehicle {

    public Car(String licensePlate,ParkingFeesStrategy parkingFeesStrategy) {
        super(licensePlate,VehicleType.CAR,parkingFeesStrategy);
    }
}

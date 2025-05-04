package practice.lld;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String licenseNumber, ParkingFeesStrategy parkingFeesStrategy) {
        switch(type) {
            case VehicleType.CAR:
                return new Car(licenseNumber, parkingFeesStrategy);
            case VehicleType.TRUCK:
                return new Truck(licenseNumber, parkingFeesStrategy);
            case BIKE:
                return new Bike(licenseNumber, parkingFeesStrategy);
            case OTHER:
            default:
                return new OtherVehicle(licenseNumber, parkingFeesStrategy);


        }
    }
}

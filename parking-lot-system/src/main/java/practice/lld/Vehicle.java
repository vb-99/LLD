package practice.lld;

public abstract class Vehicle {
    private String licensePlate;
    private VehicleType vehicleType;
    private ParkingFeesStrategy parkingFeesStrategy;

    public Vehicle(String licensePlate, VehicleType vehicleType, ParkingFeesStrategy parkingFeesStrategy) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.parkingFeesStrategy = parkingFeesStrategy;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public double getParkingFees(int duration,DurationType durationType) {
        return parkingFeesStrategy.calculateParkingFee(vehicleType,duration,durationType);
    }
}

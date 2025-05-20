package practice.lld.vehicle;

import practice.lld.Reservation;
import practice.lld.enums.VehicleStatus;
import practice.lld.enums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public abstract class Vehicle {
    private String licensePlate;
    private VehicleType vehicleType;
    private String make;
    private String model;
    private VehicleStatus vehicleStatus;
    private double baseRentalPrice;

    public Vehicle(String licensePlate, VehicleType vehicleType, String make, String model, double baseRentalPrice) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.make = make;
        this.model = model;
        this.baseRentalPrice = baseRentalPrice;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }


    public String getMake() {
        return make;
    }


    public String getModel() {
        return model;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
    public double getBaseRentalPrice() {
        return baseRentalPrice;
    }

    public abstract double getRentalPrice(int days);
}

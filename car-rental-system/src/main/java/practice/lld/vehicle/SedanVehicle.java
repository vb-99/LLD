package practice.lld.vehicle;

import practice.lld.enums.VehicleType;

public class SedanVehicle extends Vehicle{
    private static final double rateMultiplier = 1.5;

    public SedanVehicle(String licensePLate, String make,String model, double baseRentalPrice) {
        super(licensePLate, VehicleType.SEDAN,make,model,baseRentalPrice);
    }

    @Override
    public double getRentalPrice(int days) {
        return this.getBaseRentalPrice() * days * rateMultiplier ;
    }
}

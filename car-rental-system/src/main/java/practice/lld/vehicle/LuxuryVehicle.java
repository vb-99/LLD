package practice.lld.vehicle;

import practice.lld.enums.VehicleType;

public class LuxuryVehicle extends Vehicle{
    private static final double rateMultiplier = 5;

    public LuxuryVehicle(String licensePLate, String make,String model, double baseRentalPrice) {
        super(licensePLate, VehicleType.SEDAN,make,model,baseRentalPrice);
    }

    @Override
    public double getRentalPrice(int days) {
        return this.getBaseRentalPrice() * days * rateMultiplier ;
    }
}

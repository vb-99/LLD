package practice.lld.vehicle;

import practice.lld.enums.VehicleType;

public class MiniVehicle extends Vehicle{
    private static final double rateMultiplier = 1;

    public MiniVehicle(String licensePLate, String make,String model, double baseRentalPrice) {
        super(licensePLate, VehicleType.MINI,make,model,baseRentalPrice);
    }

    @Override
    public double getRentalPrice(int days) {
        return this.getBaseRentalPrice() * days * rateMultiplier ;
    }
}

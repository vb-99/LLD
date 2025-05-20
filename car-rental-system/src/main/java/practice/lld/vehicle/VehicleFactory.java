package practice.lld.vehicle;

import practice.lld.enums.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String licensePlate, String make, String model, double baseRentalPrice){
        switch (type){
            case MINI:
                return new MiniVehicle(licensePlate,make,model,baseRentalPrice);
            case SEDAN:
                return new SedanVehicle(licensePlate,make,model,baseRentalPrice);
            case SUV:
                return new SuvVehicle(licensePlate,make,model,baseRentalPrice);
            case LUXURY:
                return new LuxuryVehicle(licensePlate,make,model,baseRentalPrice);
            default:
                break;
        }
        return null;
    }
}

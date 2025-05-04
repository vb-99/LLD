package practice.lld;

public class HourlyFeesStrategy implements ParkingFeesStrategy {

    @Override
    public double calculateParkingFee(VehicleType vehicleType, int duration, DurationType durationType) {
        switch(vehicleType) {
            case CAR:
                return durationType == DurationType.HOUR ? duration * 10 : duration*10*24;
            case BIKE:
                return durationType == DurationType.HOUR ? duration * 8 : duration*8*24;
            case TRUCK:
                return durationType == DurationType.HOUR ? duration * 12 : duration*12*24;
            case OTHER:
            default:
                return durationType == DurationType.HOUR ? duration * 5 : duration*5*24;
        }
    }

}

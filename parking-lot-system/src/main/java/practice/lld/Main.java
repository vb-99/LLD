package practice.lld;

import practice.lld.payment.CashPayment;
import practice.lld.payment.CreditCardPayment;
import practice.lld.payment.PaymentStrategy;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot =
                new ParkingLot.ParkingLotBuilder()
                        .addParkingFloor(1, 2, 2,4)
                        .addParkingFloor(2, 2, 2,4)
                        .build();

        ParkingFeesStrategy basicHourlyRateStrategy = new HourlyFeesStrategy();
        // Create vehicles using Factory Pattern with fee strategies
        Vehicle car1 =
                VehicleFactory.createVehicle(VehicleType.CAR, "CAR123", basicHourlyRateStrategy);
        Vehicle bike1 =
                VehicleFactory.createVehicle(VehicleType.BIKE, "BIKE456", basicHourlyRateStrategy);
        // Park vehicles
        ParkingSlot carSpot = parkingLot.parkVehicle(car1);
        ParkingSlot bikeSpot = parkingLot.parkVehicle(bike1);
        if (carSpot != null) {
            // Calculate fee using the specific strategy for the vehicle
            double carFee = car1.getParkingFees(2, DurationType.HOUR);
            PaymentStrategy carPaymentStrategy = new CreditCardPayment();
            carPaymentStrategy.makePayment(carFee);
            parkingLot.vacate(car1);
        }
        if (bikeSpot != null) {
            // Calculate fee using the specific strategy for the vehicle
            double bikeFee = bike1.getParkingFees(2, DurationType.HOUR);
            PaymentStrategy bikePaymentStrategy = new CashPayment();
            bikePaymentStrategy.makePayment(bikeFee);
            parkingLot.vacate(bike1);
        }
    }
}
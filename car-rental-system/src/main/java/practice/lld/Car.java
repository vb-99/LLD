package practice.lld;

public class Car {
    private final String licensePlate;
    private final String company;
    private final String year;
    private final String model;
    private final double rentalPricePerDay;
    private boolean isAvailable;

    public Car(String company, String model, String year, String licensePlate, double rentalPricePerDay) {
        this.licensePlate = licensePlate;
        this.company = company;
        this.year = year;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isAvailable = true;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCompany() {
        return company;
    }

    public String getYear() {
        return year;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getModel() {
        return model;
    }
}

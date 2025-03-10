package practice.lld;

public class Customer {
    private final String name;
    private final String phoneNumber;
    private final String driversLicenseNumber;

    public Customer(String name, String phoneNumber, String driversLicenseNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }
}

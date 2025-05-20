package practice.lld;

public class Address {
    private String address;
    private String pinCode;

    public Address(String address, String pinCode) {
        this.address = address;
        this.pinCode = pinCode;
    }
    public String getAddress() {
        return address;
    }
    public String getPinCode() {
        return pinCode;
    }

}

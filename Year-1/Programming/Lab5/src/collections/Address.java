package collections;

public class Address {
    private String zipCode; //Поле не может быть null
    private Location town; //Поле может быть null

    public Address(String zipCode, Location location) {
        this.zipCode = zipCode;
        this.town = location;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Location getTown() {
        return town;
    }
}
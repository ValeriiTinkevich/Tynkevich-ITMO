package collections;

public class Address {
    private String zipCode; //Поле не может быть null
    private Location town; //Поле может быть null



    public void setTown(Location town) {
        this.town = town;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

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

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if (!(o instanceof Address address)) return false;

        return this.getZipCode().equals(address.getZipCode())
                && this.getTown().equals(address.getTown());
    }
}
package collections;

import java.time.ZonedDateTime;

public class Organization implements Comparable<Organization> {
    private int id;
    private String name;
    private Coordinates coordinates;
    private java.time.ZonedDateTime creationDate;
    private int annualTurnover;
    private String fullName;
    private Integer employeesCount;
    private OrganizationType type;
    private Address postalAddress;

    public Organization() {

    }

    public Organization(int id, String name, Coordinates coordinates, ZonedDateTime creationDate, int annualTurnover, String fullName, Integer employeesCount, OrganizationType type, Address postalAddress) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.annualTurnover = annualTurnover;
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.type = type;
        this.postalAddress = postalAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public int getAnnualTurnover() {
        return annualTurnover;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getEmployeesCount() {
        return employeesCount;
    }

    public OrganizationType getType() {
        return type;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    @Override
    public int compareTo(Organization o) {
        return this.getId() - o.getId();
    }

    @Override
    public String toString() {
        String result = String.format("Id: %d\nName: %s\nCoordinates: {x: %f, y: %d}\nCreation Time: %s\nAnnual turnover: %d\nEmployees count: %d\nOrganization Type: %s\n",
                getId(), getName(), getCoordinates().getX(), getCoordinates().getY(), getCreationDate(), getAnnualTurnover(), getEmployeesCount(), getType());
        if (getPostalAddress() == null) result += "Address: null";
        else
            result += String.format("Address: {Street: %s, ZipCode: %s}", getPostalAddress().getTown(), getPostalAddress().getZipCode());
        return result;
    }
}
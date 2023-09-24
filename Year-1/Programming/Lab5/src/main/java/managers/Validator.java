package managers;

import collections.Organization;

import java.util.ArrayList;
import java.util.Iterator;

public class Validator {
    ArrayList<Organization> organizations;

    public Validator(ArrayList<Organization> organizations) {
        this.organizations = organizations;
    }

    public ArrayList<Organization> validate() {
        Iterator<Organization> iterator = organizations.iterator();
        while (iterator.hasNext()) {
            boolean removeflag = false;
            Organization org = iterator.next();
            if (org.getId() <= 0) removeflag = true;
            if (org.getName() == null || org.getName().equals("")) removeflag = true;
            if (org.getCoordinates() == null) removeflag = true;
            if (org.getCreationDate() == null) removeflag = true;
            if (org.getAnnualTurnover() <= 0) removeflag = true;
            if (org.getFullName().equals("")) removeflag = true;
            if (org.getEmployeesCount() == null || org.getEmployeesCount() <= 0) removeflag = true;
            if (org.getPostalAddress() == null) removeflag = true;
            if (org.getCoordinates() != null) {
                if (org.getCoordinates().getX() == null || org.getCoordinates().getX() > 170) removeflag = true;
                if (org.getCoordinates().getY() == null || org.getCoordinates().getY() <= -671) removeflag = true;
            }
            if (org.getPostalAddress() != null) {
                if (org.getPostalAddress().getTown() == null || org.getPostalAddress().getZipCode() == null)
                    removeflag = true;
                if (org.getPostalAddress().getTown().getY() == null || org.getPostalAddress().getTown().getZ() == null)
                    removeflag = true;
            }
            if (removeflag) {
                iterator.remove();
                Console.println("Removing incorrect collection.... id: " + org.getId());
            }


        }
        return organizations;
    }
}

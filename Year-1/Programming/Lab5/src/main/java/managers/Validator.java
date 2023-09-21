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
        for (Iterator<Organization> iterator = organizations.iterator(); iterator.hasNext(); ) {
            Organization org = iterator.next();
            if (org.getId() <= 0) iterator.remove();
            if (org.getName() == null || org.getName().equals("")) iterator.remove();
            if (org.getCoordinates() == null) iterator.remove();
            if (org.getCreationDate() == null) iterator.remove();
            if (org.getAnnualTurnover() <= 0) iterator.remove();
            if (org.getFullName().equals("")) iterator.remove();
            if (org.getEmployeesCount() == null || org.getEmployeesCount() <= 0) iterator.remove();
            if (org.getPostalAddress() == null) iterator.remove();
            if (org.getCoordinates() != null) {
                // if (org.getCoordinates().getX() == null || org.getCoordinates().getX() > 170) iterator.remove();
                if (org.getCoordinates().getY() == null || org.getCoordinates().getY() <= -671) iterator.remove();
            }
            if (org.getPostalAddress() != null) {
                if (org.getPostalAddress().getTown() == null || org.getPostalAddress().getZipCode() == null)
                    iterator.remove();
                if (org.getPostalAddress().getTown().getY() == null || org.getPostalAddress().getTown().getZ() == null)
                    iterator.remove();
            }


        }
        return organizations;
    }
}

package managers;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import collections.Organization;

/**
 * Class that manages collections.
 */
public class CollectionManager {
    public ArrayList<Organization> organizationCollection;
    private final ZonedDateTime creationDate;

    public CollectionManager() {
        organizationCollection = new ArrayList<>();
        creationDate = ZonedDateTime.now();

    }

    /**
     * Get the creation date of the object
     *
     * @return The creation date of the collection.
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * This function returns the collection of organizations
     *
     * @return The Stack of Organization objects.
     */
    public ArrayList<Organization> getOrganizationCollection() {
        return organizationCollection;
    }

    /**
     * The setCollection function sets the organizationCollection field to the value of the
     * organizationCollection parameter
     *
     * @param organizationCollection The collection of organizations that the user is a member of.
     */
    public void setOrganizationCollection(ArrayList<Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
    }

    /**
     * Given an id, return the organization with that id
     *
     * @param id The id of the organization to be retrieved.
     * @return the response of right execution.
     */
    public Organization getById(int id) {
        for (Organization organization : organizationCollection) {
            if (organization.getId() == id) return organization;
        }
        return null;
    }

    /**
     * Given a collection of Organization objects, return the maximum id value of the collection.
     * If the collection is empty, return 0
     *
     * @return The id of the organization that was just added.
     */
    public int generateNewIdForCollection() {
        int id = organizationCollection.stream()
                .mapToInt(Organization::getId)
                .filter(organization -> organization >= 0)
                .max().orElse(0);
        return id + 1;
    }

    /**
     * Adds element to the collection.
     * @param organization is an element to be added.
     */
    public void addToCollection(Organization organization) {
        organizationCollection.add(organization);
    }

    /**
     * Clears the collection.
     */
    public void clearCollection() {
        organizationCollection.clear();
    }

    /**
     *
     * @return Returns the size of the collection.
     */
    public int getSize() {
        return organizationCollection.size();
    }

}

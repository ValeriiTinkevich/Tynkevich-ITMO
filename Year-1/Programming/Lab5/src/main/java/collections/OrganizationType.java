package collections;

public enum OrganizationType {
    COMMERCIAL,
    GOVERNMENT,
    TRUST;

    public static String nameList() {
        StringBuilder nameList = new StringBuilder();
        for (OrganizationType category : values()) {
            nameList.append(category.name()).append(", ");
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}


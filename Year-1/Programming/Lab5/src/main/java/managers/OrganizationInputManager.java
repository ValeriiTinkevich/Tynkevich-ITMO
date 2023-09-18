package managers;

import collections.Address;
import collections.Coordinates;
import collections.Location;
import collections.OrganizationType;
import exceptions.EmptyArgumentException;
import exceptions.NotInDeclaredLimitsException;

import java.time.DateTimeException;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;


/**
 * This class is used to ask the user to input the collection element.
 */
public class OrganizationInputManager {
    CollectionManager collectionManager;
    Scanner userScanner;
    private boolean scriptMode;

    /**
     * This function returns a Scanner object that is used to read user input
     *
     * @return The Scanner object that is created in the method.
     */
    public Scanner getUserScanner() {
        return userScanner;
    }

    /**
     * This function sets the scanner object that will be used to read user input
     *
     * @param userScanner The Scanner object that will be used to read user input.
     */
    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    public OrganizationInputManager(CollectionManager collectionManager, Scanner userScanner) {
        this.collectionManager = collectionManager;
        this.userScanner = userScanner;
        scriptMode = false;
    }

    /**
     * This function is used to set the script mode to true
     */
    public void setScriptMode() {
        scriptMode = true;
    }

    /**
     * This function sets the scriptMode variable to false, which means that the user is in control of
     * the CLI
     */
    public void setUserMode() {
        scriptMode = false;
    }

    public int setId() {
        return collectionManager.generateNewIdForCollection();
    }

    /**
     * Ask the user for a name and return it
     *
     * @return The name of the user.
     */
    public String askName() {
        String name;
        while (true) {
            Console.print("Enter name: ");
            try {
                name = userScanner.nextLine().trim();
                if (name.equals("")) throw new EmptyArgumentException();
                break;
            } catch (EmptyArgumentException e) {
                Console.printError("The name can't be empty!");
                Console.println(e.getMessage());

            } catch (NoSuchElementException e) {
                Console.printError("The name can't be loaded or recognized");
                if (!userScanner.hasNext()) {
                    Console.printError("Ctrl + D Caused exit!");
                    System.exit(2);
                }
            } catch (IllegalStateException e) {
                Console.printError("Unexpected error!");
            }
        }
        return name;

    }

    /**
     * Method that asks user to input the X coordinate.
     *
     * @return Returns X coordinate.
     */
    private Double askCoordX() {
        double x;
        while (true) {
            Console.print("Enter Coordinate X: ");
            try {
                String s = userScanner.nextLine().trim();
                x = Double.parseDouble(s);
                if (x > 170) {
                    throw new NotInDeclaredLimitsException();
                }
                break;
            } catch (NoSuchElementException e) {
                Console.printError("The X coordinate can't be loaded or recognized");
                if (!userScanner.hasNext()) {
                    Console.printError("Ctrl + D Caused exit!");
                    System.exit(2);
                }
            } catch (NumberFormatException e) {
                Console.printError("The X coordinate must be Double!");
            } catch (NullPointerException | IllegalStateException e) {
                Console.printError("Unexpected error!");
                System.exit(0);
            } catch (NotInDeclaredLimitsException e) {
                Console.printError("Not in declared limits or null! (x <= 170)");
            }
        }
        return x;
    }

    /**
     * Method that asks user to input the Y coordinate.
     *
     * @return Returns Y coordinate.
     */
    private Long askCoordY() {
        long y;
        while (true) {
            Console.print("Enter Coordinate Y: ");
            try {
                String s = userScanner.nextLine().trim();

                y = Long.parseLong(s);
                if (y <= -671) {
                    throw new NotInDeclaredLimitsException();
                }
                break;
            } catch (NoSuchElementException e) {
                Console.printError("The Y coordinate can't be loaded or recognized");
                if (!userScanner.hasNext()) {
                    Console.printError("Ctrl + D Caused exit!");
                    System.exit(2);
                }
            } catch (NumberFormatException e) {
                Console.printError("The Y coordinate must be Long");
            } catch (NullPointerException | IllegalStateException e) {
                Console.printError("Unexpected error!");
                System.exit(2);
            } catch (NotInDeclaredLimitsException e) {
                Console.printError("Not in declared limits or null! (y > -671");
            }
        }
        return y;
    }

    /**
     * Method that asks user to input the Z coordinate.
     *
     * @return Returns Z coordinate.
     */
    private Integer askCoordZ() {
        int y;
        while (true) {
            Console.print("Enter Coordinate Z: ");
            try {
                String s = userScanner.nextLine().trim();

                y = Integer.parseInt(s);
                break;
            } catch (NoSuchElementException e) {
                Console.printError("The Z coordinate can't be loaded or recognized");
                if (!userScanner.hasNext()) {
                    Console.printError("Ctrl + D Caused exit!");
                    System.exit(2);
                }
            } catch (NumberFormatException e) {
                Console.printError("The Z coordinate must be Integer!");
            } catch (NullPointerException | IllegalStateException e) {
                Console.printError("Unexpected error!");
                System.exit(2);
            }
        }
        return y;
    }

    /**
     * Method that asks user to input coordinates.
     *
     * @return Returns coordinates.
     */
    public Coordinates askCoordinates() {
        double x;
        long y;
        x = askCoordX();
        y = askCoordY();
        return new Coordinates(x, y);
    }

    /**
     * Method that asks user to input the location.
     *
     * @return Returns location.
     */
    public Location askLocation() {
        double x;
        Long y;
        Integer z;
        x = askCoordX();
        y = askCoordY();
        z = askCoordZ();
        return new Location(x, y, z);
    }

    /**
     * Method that asks user to input the zipcode.
     *
     * @return Returns zipcode coordinate.
     */
    private String askZipCode() {

        String zipCode;
        while (true) {
            Console.print("Enter the zip code: ");
            try {
                zipCode = userScanner.nextLine().trim();
                break;
            } catch (NoSuchElementException e) {
                Console.printError("The zip code can't be loaded or recognized");
            } catch (NullPointerException | IllegalStateException e) {
                Console.printError("Unexpected error!");
            }

        }
        return zipCode;
    }

    /**
     * Method that asks user to input the address.
     * @return Returns address.
     */
    public Address askAddress() {
        String zipCode = askZipCode();
        Location location = askLocation();
        return new Address(zipCode, location);
    }

    /**
     * Gets the time of initialization.
     *
     * @return Returns the creation date of the element.
     */
    public ZonedDateTime askCreationDate() {
        while (true) {
            try {
                return ZonedDateTime.now();
            } catch (DateTimeException e) {
                Console.printError("Problem with date and time");
            }
        }
    }

    /**
     * Method that asks user to input the organization type.
     *
     * @return Returns organization type.
     */
    public OrganizationType askOrganizationType() {
        OrganizationType organizationType;
        while (true) {
            try {
                Console.println("Organization types: " + OrganizationType.nameList());
                Console.print("Enter the organization type: ");
                String type = userScanner.nextLine().trim();
                if (type.equals("")) return null;
                organizationType = OrganizationType.valueOf(type.toUpperCase());
                break;
            } catch (NoSuchElementException e) {
                Console.printError("Type can't be recognized");
                if (!userScanner.hasNext()) {
                    Console.printError("Ctrl + D Caused an exit!");
                    System.exit(2);
                }
            } catch (IllegalArgumentException e) {
                Console.printError("Type you entered is not a category");
            }
        }
        return organizationType;
    }
    /**
     * Method that asks user to input annual turnover.
     *
     * @return Returns anual turnover.
     */
    public int askAnnualTurnover() {
        int turnOver;
        while (true) {
            try {
                Console.print("Enter Annual Turnover:");
                String s = userScanner.nextLine().trim();
                turnOver = Integer.parseInt(s);
                if (turnOver <= 0) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException e) {
                Console.printError("The annual turnover can't be loaded or recognized");
                if (!userScanner.hasNext()) {
                    Console.printError("Ctrl-D Caused exit!");
                    System.exit(0);
                }
            } catch (NumberFormatException e) {
                Console.printError("The annual turnover have to be an Integer");
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printError("Unexpected error!");
                System.exit(0);
            } catch (NotInDeclaredLimitsException e) {
                Console.printError("Annual turnover should be positive and more than 0");
            }

        }
        return turnOver;
    }
    /**
     * Method that asks user to input employees count.
     *
     * @return Returns employees count.
     */
    public Integer askEmployeesCount() {
        int employeesCount;
        while (true) {
            try {
                Console.print("Enter the amount of employees:");
                String s = userScanner.nextLine().trim();
                employeesCount = Integer.parseInt(s);
                if (employeesCount <= 0) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printError("The amount of employees can't be recognized");
                if(!userScanner.hasNext()) {
                    Console.printError("Ctrl-D Caused exit!");
                    System.exit(0);
                }
            } catch (NotInDeclaredLimitsException exception) {
                Console.printError("The amount of employees should be more than 0");
            } catch (NumberFormatException exception) {
                Console.printError("The amount of employees should be Integer");
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printError("Unexpected error!");
                System.exit(0);
            }
        }
        return employeesCount;
    }
    /**
     * Method that asks user to input full name.
     *
     * @return Returns full name.
     */
    public String askFullName() {
        String fullName;
        while (true) {
            Console.print("Enter the full name: ");
            try {
                fullName = userScanner.nextLine().trim();
                if (fullName.isEmpty()) return null;
                String finalFullName = fullName;
                if (collectionManager.getOrganizationCollection()
                        .stream()
                        .anyMatch(organization -> Objects.equals(organization.getFullName(), finalFullName))) {
                    throw new NotInDeclaredLimitsException();
                }
                break;
            } catch (NoSuchElementException e) {
                Console.printError("The full name can't be loaded or recognized");
            } catch (NullPointerException | IllegalStateException e) {
                Console.printError("Unexpected error!");
            } catch (NotInDeclaredLimitsException e) {
                Console.println("Full name must be unique!");
            }

        }
        return fullName;
    }

}

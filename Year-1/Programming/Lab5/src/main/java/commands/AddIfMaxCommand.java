package commands;

import collections.Organization;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.Console;
import managers.OrganizationInputManager;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class AddIfMaxCommand extends AbstractCommand {
    OrganizationInputManager organizationInputManager;
    CollectionManager collectionManager;

    public AddIfMaxCommand(OrganizationInputManager organizationInputManager, CollectionManager collectionManager) {
        super("add_if_max", "Adds element if it has bigger value than MAX in collection");
        this.organizationInputManager = organizationInputManager;
        this.collectionManager = collectionManager;
    }

    /**
     * If the collection is empty, the element is added to the collection.
     * If the collection is not empty, compares their annual turnovers and adds element if the turnover is max.
     *
     * @param argument The argument that is entered via command line.
     * @return the response of right execution.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            Organization askerOrganization = new Organization(
                    organizationInputManager.setId(),
                    organizationInputManager.askName(),
                    organizationInputManager.askCoordinates(),
                    organizationInputManager.askCreationDate(),
                    organizationInputManager.askAnnualTurnover(),
                    organizationInputManager.askFullName(),
                    organizationInputManager.askEmployeesCount(),
                    organizationInputManager.askOrganizationType(),
                    organizationInputManager.askAddress()
            );

            if (collectionManager.getSize() == 0) {
                collectionManager.addToCollection(askerOrganization);
                Console.println("Organization was added successfully!");
                return true;
            }

            Organization maxOrganization = collectionManager.getOrganizationCollection()
                    .stream()
                    .max(Comparator.comparing(Organization::getAnnualTurnover))
                    .orElseThrow(NoSuchElementException::new);
            if (askerOrganization.compareTo(maxOrganization) > 0) {
                collectionManager.addToCollection(askerOrganization);
                Console.println("Organization was added successfully!");
            } else {
                Console.println("Organization annual turnover is not enough to add");
            }

        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e.getMessage());
            return false;
        } catch (IncorrectInputInScriptException ignore) {
        }
        return false;
    }


}

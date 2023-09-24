package commands;

import collections.Organization;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.Console;
import managers.OrganizationInputManager;

public class AddElementCommand extends AbstractCommand {

    private OrganizationInputManager organizationInputManager;
    private CollectionManager collectionManager;

    public AddElementCommand(OrganizationInputManager organizationInputManager, CollectionManager collectionManager) {
        super("add", "Adds and element to collection");
        this.organizationInputManager = organizationInputManager;
        this.collectionManager = collectionManager;
    }

    /**
     * Adds element to the collection.
     *
     * @param argument The argument that is entered via command line.
     * @return The response of right execution.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            collectionManager.addToCollection(new Organization(
                    organizationInputManager.setId(),
                    organizationInputManager.askName(),
                    organizationInputManager.askCoordinates(),
                    organizationInputManager.askCreationDate(),
                    organizationInputManager.askAnnualTurnover(),
                    organizationInputManager.askFullName(),
                    organizationInputManager.askEmployeesCount(),
                    organizationInputManager.askOrganizationType(),
                    organizationInputManager.askAddress()
            ));
            Console.println("Organization was added successfully!");
            return true;
        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e.getMessage());
            return false;
        } catch (IncorrectInputInScriptException ignore) {
        }
        return false;
    }


}


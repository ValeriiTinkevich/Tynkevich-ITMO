package commands;

import collections.Organization;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.Console;
import managers.OrganizationInputManager;

public class UpdateByIdCommand extends AbstractCommand {
    CollectionManager collectionManager;
    OrganizationInputManager organizationInputManager;

    public UpdateByIdCommand(CollectionManager collectionManager, OrganizationInputManager organizationInputManager) {
        super("update", "Updates element by id");
        this.collectionManager = collectionManager;
        this.organizationInputManager = organizationInputManager;

    }

    /**
     * @param argument
     * @return if execute is failed or completed
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            int id = Integer.parseInt(argument);
            collectionManager.update(id, new Organization(
                    id,
                    organizationInputManager.askName(),
                    organizationInputManager.askCoordinates(),
                    organizationInputManager.askCreationDate(),
                    organizationInputManager.askAnnualTurnover(),
                    organizationInputManager.askFullName(),
                    organizationInputManager.askEmployeesCount(),
                    organizationInputManager.askOrganizationType(),
                    organizationInputManager.askAddress()));
            Console.println("Organization updated successfully!");
            return true;
        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e.getMessage());
        } catch (NumberFormatException e) {
            Console.printError("id must be Integer!");
        } catch (IncorrectInputInScriptException ignore) {
        }
        return false;
    }

}

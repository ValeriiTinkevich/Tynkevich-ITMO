package commands;

import collections.Organization;
import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.Console;

public class ShowCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        super("show", "Displays collection elements as Strings");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            if (collectionManager.getOrganizationCollection().size() == 0) {
                Console.println("Collection is empty.");
            } else {
                for (Organization organization : collectionManager.getOrganizationCollection()) {
                    Console.println(organization.toString() + "\n===============");

                }
            }
            return true;
        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e.getMessage());
        }
        return false;
    }

}

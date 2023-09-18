package commands;

import collections.Organization;
import managers.CollectionManager;
import managers.Console;

public class ShowCommand extends AbstractCommand{
    CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager) {
        super("show", "Displays collection elements as Strings");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        for (Organization organization : collectionManager.getOrganizationCollection()) {
            Console.println(organization.toString() + "\n===============");

        }
        return true;
    }

}

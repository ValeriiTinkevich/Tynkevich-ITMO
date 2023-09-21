package commands;

import collections.Address;
import collections.Organization;
import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.Console;
import managers.OrganizationInputManager;

import java.util.ArrayList;
import java.util.Iterator;

public class RemoveAllByPostalCodeAddress extends AbstractCommand {
    CollectionManager collectionManager;
    OrganizationInputManager oim;

    public RemoveAllByPostalCodeAddress(CollectionManager collectionManager, OrganizationInputManager OIM) {
        super("remove_all_by_postal_address", "Removes all elements with given Postal Address");
        this.collectionManager = collectionManager;
        this.oim = OIM;
    }

    /**
     * @param argument
     * @return s
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            int counter = collectionManager.removeAllByPostalCodeFromCollection(oim.askAddress());
            if (counter == 0) {
                Console.println("No organization found.");
            } else {
                Console.println("Removed " + counter + " organizations from the collection");
            }
            return true;
        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e.getMessage());
            return false;
        }
    }
}

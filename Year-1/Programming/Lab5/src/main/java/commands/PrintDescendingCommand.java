package commands;

import collections.Organization;
import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.Console;

public class PrintDescendingCommand extends AbstractCommand{
    CollectionManager collectionManager;
    public PrintDescendingCommand(CollectionManager collectionManager) {
        super("print_descending", "Displays all collection elements descending");
        this.collectionManager = collectionManager;
    }

    /**
     * @param argument
     * @return
     */
    @Override
    public boolean execute(String argument) {
        try {
            if(!argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            for (Organization organization: collectionManager.getReverse()) {
                Console.println(organization.toString() + "\n===============");
            }
        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e.getMessage());
            return false;
        }
        return true;
    }
}

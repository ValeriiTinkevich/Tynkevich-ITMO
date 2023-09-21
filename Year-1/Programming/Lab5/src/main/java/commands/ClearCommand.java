package commands;

import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.Console;

public class ClearCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "Clears collection");
        this.collectionManager = collectionManager;
    }

    /**
     * Clear the collection
     *
     * @param argument The argument that is entered via command line.
     * @return the response of right execution.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            collectionManager.clearCollection();
            Console.println("Collection cleared!");
            return true;

        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e.getMessage());
            return false;
        }

    }


}
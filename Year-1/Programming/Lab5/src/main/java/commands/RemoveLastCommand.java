package commands;

import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.Console;

public class RemoveLastCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public RemoveLastCommand(CollectionManager collectionManager) {
        super("remove_last", "Removes last element from collection");
        this.collectionManager = collectionManager;
    }

    /**
     * @param argument
     * @return
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            collectionManager.removeLast();
            Console.println("Successfully removed the element");
            return true;
        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            Console.printError("Collection is empty!");
        }
        return false;
    }
}


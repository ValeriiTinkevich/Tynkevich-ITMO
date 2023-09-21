package commands;

import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.Console;

public class RemoveFirstCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public RemoveFirstCommand(CollectionManager collectionManager) {
        super("remove_first", "Removes first element from collection");
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
            collectionManager.removeFirst();
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

package commands;

import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.Console;

public class MinByIdCommand extends AbstractCommand{
    private final CollectionManager collectionManager;

    public MinByIdCommand(CollectionManager collectionManager) {
        super("min_by_id", "Displays collection element with lowest id");
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
            Console.println(collectionManager.minById().toString());
        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e.getMessage());
            return false;
        }
        return true;
    }

}

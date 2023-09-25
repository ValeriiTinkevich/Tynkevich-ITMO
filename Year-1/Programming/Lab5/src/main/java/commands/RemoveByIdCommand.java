package commands;

import exceptions.MustNotBeEmptyException;
import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.Console;

public class RemoveByIdCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager) {
        super("remove_by_id", "Removes element by id");
        this.collectionManager = collectionManager;
    }

    /**
     * @param argument
     * @return
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            int id = Integer.parseInt(argument);
            if (collectionManager.getById(id) == null) throw new MustNotBeEmptyException();
            collectionManager.removeByIDFromCollection(id);
            Console.println("Successfully removed the element");
            return true;

        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e.getMessage());
        } catch (MustNotBeEmptyException e) {
            Console.printError("No organization with this id");
        } catch (NumberFormatException e) {
            Console.printError("The id value must be int!");
        }
        return false;
    }
}

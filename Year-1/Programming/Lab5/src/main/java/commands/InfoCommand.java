package commands;

import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.Console;

public class InfoCommand extends AbstractCommand{
    CollectionManager collectionManager;
    public InfoCommand(CollectionManager collectionManager) {
        super("info", "Displays information about Collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if(!argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            Console.println("Collection used is: " +  collectionManager.getOrganizationCollection()
                    .getClass()
                    .toString()
                    .replace("class java.util.", ""));
            Console.println("Initialization time is: " + collectionManager.getCreationDate().toString());
            Console.println("Current size of collection is: " + collectionManager.getSize() +" elements");
            return true;
        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e.getMessage());
            return false;
        }
    }

}

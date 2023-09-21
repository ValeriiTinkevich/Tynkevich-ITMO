package commands;

import exceptions.WrongAmountOfArgumentsException;
import managers.Console;

public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        super("exit", "Exits console");
    }

    /**
     * Exit the program
     *
     * @param argument The argument passed to the command.
     * @return the response of right execution.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            Console.println("Exiting the program...");
            System.exit(0);
        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e);
            return false;
        }
        return true;
    }

}

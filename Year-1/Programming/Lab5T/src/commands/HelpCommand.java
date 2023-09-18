package commands;

import exceptions.WrongAmountOfArgumentsException;
import managers.Console;

import java.util.Map;

public class HelpCommand extends AbstractCommand {
    Map<String, ICommand> commands;

    public HelpCommand(Map<String, ICommand> commands) {
        super("help", "Displays help on available commands");
        this.commands = commands;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            for (String name : commands.keySet()) {
                String value = commands.get(name).toString();
                Console.println(value);
            }


        } catch (WrongAmountOfArgumentsException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }
}

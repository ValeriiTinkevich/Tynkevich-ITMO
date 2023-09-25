package commands;

import exceptions.WrongAmountOfArgumentsException;
import managers.Console;
import managers.OrganizationInputManager;

public class ExecuteScriptCommand extends AbstractCommand {
    OrganizationInputManager organizationInputManager;
    Console console;

    public ExecuteScriptCommand(OrganizationInputManager organizationInputManager) {
        super("execute", "Executes a script from given file");
        this.organizationInputManager = organizationInputManager;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    /**
     * @param argument
     * @return
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            organizationInputManager.setScriptMode();
            console.scriptMode(argument);
            return true;
        } catch (WrongAmountOfArgumentsException e) {
            Console.println(e.getMessage());
        }
        return false;
    }
}


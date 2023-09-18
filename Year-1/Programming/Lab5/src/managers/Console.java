package managers;

import commands.ICommand;
import exceptions.WrongAmountOfArgumentsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Class that allows interaction with command line.
 */
public class Console {
    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";

    private final CommandManager commandManager;
    private final Scanner userScanner;
    private final OrganizationInputManager organizationInputManager;
    private final List<String> scriptStack = new ArrayList<>();

    public Console(CommandManager commandManager, Scanner userScanner, OrganizationInputManager organizationInputManager) {
        this.commandManager = commandManager;
        this.userScanner = userScanner;
        this.organizationInputManager = organizationInputManager;
    }

    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }
    public static void printError(Object obj) {
        Console.println("Error: " + obj);
    }

    public void interactiveMode() throws WrongAmountOfArgumentsException {
            do {
            try {
                String[] userCommand;
                int commandStatus;
                userCommand = (userScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                ICommand command = commandManager.commands.get(userCommand[0]);
                command.execute(userCommand[1]);
            }
            catch (NullPointerException e) {
                printError("No such command");
            }
        } while (userScanner.hasNext());

    }



}

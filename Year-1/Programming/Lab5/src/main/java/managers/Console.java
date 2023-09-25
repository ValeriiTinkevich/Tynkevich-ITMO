package managers;

import commands.ICommand;
import exceptions.ScriptRecursionException;
import exceptions.WrongAmountOfArgumentsException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
            } catch (NullPointerException e) {
                Console.println(e.getMessage());
            }
        } while (userScanner.hasNext());

    }
    public int scriptMode(String argument) {
        String[] userCommand;
        scriptStack.add(argument);
        try (Scanner scriptScanner = new Scanner(new File(argument))) {
            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
            Scanner tmpScanner = organizationInputManager.getUserScanner();
            organizationInputManager.setUserScanner(scriptScanner);
            organizationInputManager.setScriptMode();
            do {
                userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                while (scriptScanner.hasNextLine() && userCommand[0].isEmpty()) {
                    userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                    userCommand[1] = userCommand[1].trim();
                }
                Console.println(Console.PS1 + String.join(" ", userCommand));
                if (userCommand[0].equals("execute_script")) {
                    for (String script : scriptStack) {
                        if (userCommand[1].equals(script)) throw new ScriptRecursionException();
                    }
                }
                ICommand command = commandManager.commands.get(userCommand[0]);
                command.execute(userCommand[1]);
            } while (scriptScanner.hasNextLine());
            organizationInputManager.setUserScanner(tmpScanner);
            organizationInputManager.setUserMode();
            if (!(userCommand[0].equals("execute_script") && !userCommand[1].isEmpty()))
                Console.println("Check script for correct input data!");
            return 0;
        } catch (FileNotFoundException exception) {
            Console.printError("File was not found!");
        } catch (NoSuchElementException exception) {
            Console.printError("Script file is empty!");
        } catch (ScriptRecursionException exception) {
            Console.printError("Scripts can't be recursive!");
        } catch (IllegalStateException exception) {
            Console.printError("Unexpected error!");
            System.exit(0);
        } finally {
            scriptStack.remove(scriptStack.size()-1);
        }
        return 1;
    }

}

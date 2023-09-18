import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfArgumentsException;
import managers.CollectionManager;
import managers.CommandManager;
import managers.Console;
import managers.OrganizationInputManager;

import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, WrongAmountOfArgumentsException, IncorrectInputInScriptException {
        Scanner userScanner = new Scanner(System.in);
        CollectionManager clm = new CollectionManager();
        OrganizationInputManager om = new OrganizationInputManager(clm, userScanner);
        CommandManager cm = new CommandManager(om, clm);
        Console cs = new Console(cm, userScanner, om);

        cs.interactiveMode();
    }
}


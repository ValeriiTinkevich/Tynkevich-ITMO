import commands.ExecuteScriptCommand;
import commands.ICommand;
import exceptions.WrongAmountOfArgumentsException;
import managers.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongAmountOfArgumentsException, FileNotFoundException {
        String filename = "text.xml";
        Scanner userScanner = new Scanner(System.in);
        CollectionManager clm = new CollectionManager();
        if(args.length == 0) {
            Console.println("Using default filename: " + filename);
        } else if (args.length > 1) {
            Console.printError("More arguments than expected! (" + args.length  +", 1 expected)");
            System.exit(1);
        } else {
            filename = args[0];
            Console.println("Using file " + filename);
        }
        FileReader fr = new FileReader(filename);
        OrganizationInputManager om = new OrganizationInputManager(clm, userScanner);
        CommandManager cm = new CommandManager(om, clm, fr);
        Console cs = new Console(cm, userScanner, om);
        ExecuteScriptCommand command = (ExecuteScriptCommand) cm.getCommands().get("execute_script");
        command.setConsole(cs);

        clm.setOrganizationCollection(fr.readCollection());
        //cs.scriptMode("script.txt");
        cs.interactiveMode();
        //cs.scriptMode("script.txt");
    }
}


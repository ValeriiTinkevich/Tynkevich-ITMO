import exceptions.WrongAmountOfArgumentsException;
import managers.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongAmountOfArgumentsException {
        Scanner userScanner = new Scanner(System.in);
        CollectionManager clm = new CollectionManager();
        FileReader fr = new FileReader("C:\\Users\\barm2\\Desktop\\Year-1\\Year-1\\Programming\\Lab5\\src\\main\\resources\\text.xml");
        OrganizationInputManager om = new OrganizationInputManager(clm, userScanner);
        CommandManager cm = new CommandManager(om, clm, fr);
        Console cs = new Console(cm, userScanner, om);

        //clm.setOrganizationCollection(fr.readCollection());
        cs.interactiveMode();


    }
}


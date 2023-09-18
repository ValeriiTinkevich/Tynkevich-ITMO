package commands;

public class ShowCommand extends AbstractCommand{
    public ShowCommand() {
        super("show", "Displays collection elements as Strings");
    }

    @Override
    public boolean execute(String argument) {
        return true;
    }

}

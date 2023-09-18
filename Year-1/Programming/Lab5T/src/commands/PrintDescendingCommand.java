package commands;

public class PrintDescendingCommand extends AbstractCommand{
    public PrintDescendingCommand() {
        super("print_descending", "Displays all collection elements descending");
    }

    /**
     * @param argument
     * @return
     */
    @Override
    public boolean execute(String argument) {
        return true;
    }
}

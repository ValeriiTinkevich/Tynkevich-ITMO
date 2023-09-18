package commands;

public class RemoveFirstCommand extends AbstractCommand{
    public RemoveFirstCommand() {
        super("remove_first", "Removes first element from collection");
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

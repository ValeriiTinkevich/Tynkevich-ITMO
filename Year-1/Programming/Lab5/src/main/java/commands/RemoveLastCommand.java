package commands;

public class RemoveLastCommand extends AbstractCommand{
    public RemoveLastCommand() {
        super("remove_last", "Removes last element from collection");
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

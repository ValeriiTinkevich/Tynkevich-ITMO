package commands;

public class RemoveByIdCommand extends AbstractCommand{
    public RemoveByIdCommand() {
        super("remove_by_id", "Removes element by id");
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

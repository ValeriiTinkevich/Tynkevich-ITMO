package commands;

public class MinByIdCommand extends AbstractCommand{
    public MinByIdCommand() {
        super("min_by_id", "Displays collection element with lowest id");
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

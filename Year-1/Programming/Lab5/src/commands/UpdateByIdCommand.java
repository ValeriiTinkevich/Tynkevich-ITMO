package commands;

public class UpdateByIdCommand extends AbstractCommand{
    public UpdateByIdCommand() {
        super("update_id", "Updates id for an element by id");
    }

    /**
     * @param argument
     * @return if execute is failed or completed
     */
    @Override
    public boolean execute(String argument) {
        return true;
    }

}

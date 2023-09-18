package commands;

public class SaveCommand extends AbstractCommand{
    public SaveCommand() {
        super("save", "Saves collection to a file");
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

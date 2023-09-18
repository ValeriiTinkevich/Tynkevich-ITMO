package commands;

public class ExecuteScriptCommand extends AbstractCommand {
    public ExecuteScriptCommand() {
        super("execute", "Executes a script from given file");
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


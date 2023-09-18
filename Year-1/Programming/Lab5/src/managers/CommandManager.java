package managers;
import commands.*;
import java.util.Map;

import java.util.HashMap;

/**
 * Class that manages commands.
 */
public class CommandManager {
    private final int COMMAND_HISTORY_SIZE = 8;
    public final Map<String, ICommand> commands;
    private final String[] commandHistory = new String[COMMAND_HISTORY_SIZE];
    OrganizationInputManager organizationInputManager;
    CollectionManager collectionManager;
    public CommandManager(OrganizationInputManager organizationInputManager, CollectionManager collectionManager) {
        this.organizationInputManager = organizationInputManager;
        this.collectionManager = collectionManager;
        commands = new HashMap<>();
        commands.put("help", new HelpCommand(this.commands));
        commands.put("info", new InfoCommand(this.collectionManager));
        commands.put("show", new ShowCommand());
        commands.put("add", new AddElementCommand(this.organizationInputManager, this.collectionManager));
        commands.put("add_if_max", new AddIfMaxCommand(this.organizationInputManager, this.collectionManager));
        commands.put("update_id", new UpdateByIdCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("clear", new ClearCommand(collectionManager));
        commands.put("save", new SaveCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("exit", new ExitCommand());

    }

    /**
     * Returns the Map of commands.
     * @return returns Map of commands.
     */
    public Map<String, ICommand> getCommands() {
        return commands;
    }


}

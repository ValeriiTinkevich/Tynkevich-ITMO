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
    //private final String[] commandHistory = new String[COMMAND_HISTORY_SIZE];
    OrganizationInputManager organizationInputManager;
    CollectionManager collectionManager;
    FileManager fileManager;

    public CommandManager(OrganizationInputManager organizationInputManager, CollectionManager collectionManager, FileManager fileManager) {
        this.organizationInputManager = organizationInputManager;
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
        commands = new HashMap<>();
        commands.put("help", new HelpCommand(this.commands));
        commands.put("info", new InfoCommand(this.collectionManager));
        commands.put("show", new ShowCommand(this.collectionManager));
        commands.put("add", new AddElementCommand(this.organizationInputManager, this.collectionManager));
        commands.put("add_if_max", new AddIfMaxCommand(this.organizationInputManager, this.collectionManager));
        commands.put("update", new UpdateByIdCommand(this.collectionManager, this.organizationInputManager));
        commands.put("remove_by_id", new RemoveByIdCommand(this.collectionManager));
        commands.put("clear", new ClearCommand(this.collectionManager));
        commands.put("save", new SaveCommand(this.collectionManager, this.fileManager));
        commands.put("execute_script", new ExecuteScriptCommand(this.organizationInputManager));
        commands.put("exit", new ExitCommand());
        commands.put("min_by_id", new MinByIdCommand(this.collectionManager));
        commands.put("print_descending", new PrintDescendingCommand(this.collectionManager));
        commands.put("remove_all_by_postal_address", new RemoveAllByPostalCodeAddress(this.collectionManager, this.organizationInputManager));
        commands.put("remove_first", new RemoveFirstCommand(this.collectionManager));
        commands.put("remove_last", new RemoveLastCommand(this.collectionManager));
    }

    /**
     * Returns the Map of commands.
     *
     * @return returns Map of commands.
     */
    public Map<String, ICommand> getCommands() {
        return commands;
    }


}

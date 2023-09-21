package commands;

/**
 * Interface for all commands.
 */

public interface ICommand {
    String getDescription();

    String getName();

    /**
     * @param argument The argument passed to the command.
     * @return The argument that is entered via command line
     */
    boolean execute(String argument);


}

package commands;

import managers.CollectionManager;
import managers.FileManager;

public class SaveCommand extends AbstractCommand {
    CollectionManager collectionManager;
    FileManager fileManager;

    public SaveCommand(CollectionManager collectionManager, FileManager fileManager) {
        super("save", "Saves collection to a file");
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
    }

    /**
     * @param argument
     * @return
     */
    @Override
    public boolean execute(String argument) {
        fileManager.writeCollection(collectionManager.getOrganizationCollection());
        return true;
    }

}

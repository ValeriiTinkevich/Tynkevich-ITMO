package commands;

import managers.CollectionManager;
import managers.FileReader;

public class SaveCommand extends AbstractCommand{
    CollectionManager collectionManager;
    FileReader fileReader;
    public SaveCommand(CollectionManager collectionManager, FileReader fileReader) {
        super("save", "Saves collection to a file");
        this.collectionManager = collectionManager;
        this.fileReader = fileReader;
    }

    /**
     * @param argument
     * @return
     */
    @Override
    public boolean execute(String argument) {
        fileReader.writeCollection(collectionManager.getOrganizationCollection());
        return true;
    }

}

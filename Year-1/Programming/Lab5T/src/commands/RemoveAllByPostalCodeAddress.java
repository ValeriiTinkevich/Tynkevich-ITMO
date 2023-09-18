package commands;

public class RemoveAllByPostalCodeAddress extends AbstractCommand{
    public RemoveAllByPostalCodeAddress() {
        super("Remove_all_by_postal_address", "Removes all elements with given Postal Address");
    }

    /**
     * @param argument
     * @return s
     */
    @Override
    public boolean execute(String argument) {
        return true;
    }

}

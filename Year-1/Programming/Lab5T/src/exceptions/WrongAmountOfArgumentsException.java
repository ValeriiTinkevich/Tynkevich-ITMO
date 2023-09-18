package exceptions;

/**
 * Is thrown when the amount of arguments is wrong.
 */

public class WrongAmountOfArgumentsException extends Exception{
    String message = "WrongAmountOfElementsException: you have entered wrong amount of arguments!";

    @Override
    public String getMessage() {
        return message;
    }
}

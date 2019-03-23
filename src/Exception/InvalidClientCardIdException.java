package Exception;

public class InvalidClientCardIdException extends RuntimeException {

    public InvalidClientCardIdException(String message) {
        super(message);
    }
}
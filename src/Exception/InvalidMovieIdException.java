package Exception;

public class InvalidMovieIdException extends RuntimeException {

    public InvalidMovieIdException(String message) {
        super(message);
    }
}

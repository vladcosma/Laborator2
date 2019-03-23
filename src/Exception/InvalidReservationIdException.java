package Exception;

public class InvalidReservationIdException extends RuntimeException {

    public InvalidReservationIdException(String message) {
        super(message);
    }
}

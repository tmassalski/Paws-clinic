package pl.tmassalski.vetservice.domain.owner;

public class OwnerException extends RuntimeException {

    public OwnerException() {
    }

    public OwnerException(String message) {
        super(message);
    }

    public OwnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public OwnerException(Throwable cause) {
        super(cause);
    }
}

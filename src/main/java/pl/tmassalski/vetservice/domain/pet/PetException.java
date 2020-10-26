package pl.tmassalski.vetservice.domain.pet;

public class PetException extends RuntimeException {

    public PetException() {
    }

    public PetException(String message) {
        super(message);
    }

    public PetException(String message, Throwable cause) {
        super(message, cause);
    }

    public PetException(Throwable cause) {
        super(cause);
    }
}

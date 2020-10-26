package pl.tmassalski.vetservice.domain.pet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PetTypeException extends RuntimeException {

    public PetTypeException() {
        super();
    }

    public PetTypeException(String message) {
        super(message);
    }

    public PetTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PetTypeException(Throwable cause) {
        super(cause);
    }

    public static PetTypeException idNotFound() {
        return new PetTypeException();
    }
}

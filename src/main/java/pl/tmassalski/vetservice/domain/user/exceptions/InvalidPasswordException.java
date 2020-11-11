package pl.tmassalski.vetservice.domain.user.exceptions;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super("Incorrect password.");
    }
}

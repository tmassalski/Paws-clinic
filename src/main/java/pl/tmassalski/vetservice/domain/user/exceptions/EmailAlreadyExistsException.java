package pl.tmassalski.vetservice.domain.user.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String email) {
        super("User is already registered under email : " + email);
    }
}

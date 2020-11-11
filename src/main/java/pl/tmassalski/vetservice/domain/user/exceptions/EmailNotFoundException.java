package pl.tmassalski.vetservice.domain.user.exceptions;

public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException(String email) {
        super("Can't find email: " +email);
    }
}

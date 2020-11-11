package pl.tmassalski.vetservice.domain.user.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String username) {
        super("This username has been already taken: " + username);
    }
}
package pl.tmassalski.vetservice.domain.user;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String email) {
        super("User is already registered under email : " + email);
    }
}

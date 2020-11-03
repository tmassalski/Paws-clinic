package pl.tmassalski.vetservice.domain.user;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super("Can't find username: " +username);
    }
}

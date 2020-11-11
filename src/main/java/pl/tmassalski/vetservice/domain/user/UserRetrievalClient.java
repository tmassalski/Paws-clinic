package pl.tmassalski.vetservice.domain.user;

public interface UserRetrievalClient {

    boolean emailExists(String email);
    boolean usernameExists(String username);
    User findByUsername(String username);
    User findByEmail(String email);
}

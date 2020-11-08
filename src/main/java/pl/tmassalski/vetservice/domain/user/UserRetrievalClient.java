package pl.tmassalski.vetservice.domain.user;

public interface UserRetrievalClient {

    boolean emailExists(String email);
}

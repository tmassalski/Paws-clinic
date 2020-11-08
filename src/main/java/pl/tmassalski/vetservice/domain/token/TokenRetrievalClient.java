package pl.tmassalski.vetservice.domain.token;

public interface TokenRetrievalClient {

    Token getByValue(String tokenValue);

}
package pl.tmassalski.vetservice.domain.token;

public class TokenNotFoundException extends RuntimeException {
    public TokenNotFoundException(String tokenValue) {
        super("Cannot find token " + tokenValue);
    }
}
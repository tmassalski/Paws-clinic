package pl.tmassalski.vetservice.infrastructure.token;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.vetservice.domain.token.Token;
import pl.tmassalski.vetservice.domain.token.TokenNotFoundException;
import pl.tmassalski.vetservice.domain.token.TokenRetrievalClient;

@Service
@RequiredArgsConstructor
class TokenRetrievalPostgresClient implements TokenRetrievalClient {

    private final TokenRepository tokenRepository;

    @Override
    public Token getByValue(String tokenValue) {
        return tokenRepository.findByValue(tokenValue).orElseThrow(() -> new TokenNotFoundException(tokenValue));
    }
}
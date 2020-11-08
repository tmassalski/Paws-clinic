package pl.tmassalski.vetservice.infrastructure.token;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.vetservice.domain.token.Token;
import pl.tmassalski.vetservice.domain.token.TokenCreatorClient;

@Service
@RequiredArgsConstructor
class TokenCreatorPostgresClient implements TokenCreatorClient {

    private final TokenRepository tokenRepository;

    @Override
    public void add(Token token) {
        tokenRepository.save(token);
    }
}
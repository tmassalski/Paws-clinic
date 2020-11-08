package pl.tmassalski.vetservice.domain.token;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.vetservice.domain.user.User;

@Service
@RequiredArgsConstructor
public class TokenFacade {

    private final TokenRetrievalClient tokenRetrievalClient;
    private final TokenCreatorClient tokenCreatorClient;
    private final TokenSender tokenSender;

    public Token getByValue(String tokenValue) {
        return tokenRetrievalClient.getByValue(tokenValue);
    }

    public void generateAndSendToken(User user) {
        Token token = Token.generate(user);
        tokenCreatorClient.add(token);
        tokenSender.sendToken(token, user);
    }
}
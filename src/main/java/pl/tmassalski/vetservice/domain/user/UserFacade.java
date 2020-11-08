package pl.tmassalski.vetservice.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tmassalski.vetservice.domain.token.TokenFacade;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserCreatorClient userCreatorClient;
    private final UserUpdaterClient userUpdaterClient;
    private final UserCreator userCreator;
    private final TokenFacade tokenFacade;

    @Transactional
    public User registerNewUser(UserCommand command) {
        User user = userCreator.verifyAndCreateUser(command);
        tokenFacade.generateAndSendToken(user);
        return userCreatorClient.register(user);
    }

    public void updateUser(User user) {
        userUpdaterClient.update(user);
    }
}

package pl.tmassalski.vetservice.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tmassalski.vetservice.domain.token.TokenFacade;
import pl.tmassalski.vetservice.domain.user.exceptions.InvalidPasswordException;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserCreatorClient userCreatorClient;
    private final UserUpdaterClient userUpdaterClient;
    private final UserRetrievalClient userRetrievalClient;
    private final UserCreator userCreator;
    private final UserValidator userValidator;
    private final TokenFacade tokenFacade;
    private final PasswordChanger passwordChanger;
    private final PasswordSender passwordSender;

    @Transactional
    public User registerNewUser(UserCommand command) {
        User user = userCreator.verifyAndCreateUser(command);
        tokenFacade.generateAndSendToken(user);
        return userCreatorClient.register(user);
    }

    @Transactional
    public void resetPassword(String email) {
        User user = userRetrievalClient.findByEmail(email);
        String generatedPassword = passwordChanger.setRandomPassword(user);
        passwordSender.sendPassword(user, generatedPassword);
    }

    @Transactional
    public void changePassword(String username, String currentPassword, String newPassword) {
        User user = userRetrievalClient.findByUsername(username);
        if(!userValidator.validatePassword(user, currentPassword)){
            throw new InvalidPasswordException();
        }
        passwordChanger.updatePassword(user, newPassword);
    }

    @Transactional
    public void activateUserAccount(User user) {
        user.setEnabled(true);
        userUpdaterClient.update(user);
    }
}

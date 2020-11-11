package pl.tmassalski.vetservice.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.tmassalski.vetservice.domain.user.exceptions.EmailAlreadyExistsException;
import pl.tmassalski.vetservice.domain.user.exceptions.UserAlreadyExistsException;

@Service
@RequiredArgsConstructor
class UserCreator {

    private final PasswordEncoder passwordEncoder;
    private final UserValidator userValidator;

    User verifyAndCreateUser(UserCommand command) {
        if (userValidator.validateUsername(command.getUsername())) {
            throw new UserAlreadyExistsException(command.getUsername());
        }
        if (userValidator.validateEmail(command.getEmail()) || userValidator.validateUsername(command.getUsername())) {
            throw new EmailAlreadyExistsException(command.getEmail());
        }
        User user = User.generate(command);
        user.setPassword(passwordEncoder.encode(command.getPassword()));
        return user;
    }
}

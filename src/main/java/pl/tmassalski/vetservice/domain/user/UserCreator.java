package pl.tmassalski.vetservice.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserCreator {

    private final PasswordEncoder passwordEncoder;
    private final EmailValidator emailValidator;

    User verifyAndCreateUser(UserCommand command) {
        if (emailValidator.validate(command.getEmail())) {
            throw new UserAlreadyExistsException(command.getEmail());
        }
        User user = User.generate(command);
        user.setPassword(passwordEncoder.encode(command.getPassword()));
        return user;
    }
}

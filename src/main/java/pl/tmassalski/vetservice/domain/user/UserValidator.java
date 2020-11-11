package pl.tmassalski.vetservice.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserValidator {

    private final UserRetrievalClient userRetrievalClient;
    private final PasswordEncoder passwordEncoder;

    boolean validateEmail(String email){
        return userRetrievalClient.emailExists(email);
    }

    boolean validateUsername(String username){
        return userRetrievalClient.usernameExists(username);
    }

    boolean validatePassword(User user, String password){
        return passwordEncoder.matches(password, user.getPassword());
    }
}
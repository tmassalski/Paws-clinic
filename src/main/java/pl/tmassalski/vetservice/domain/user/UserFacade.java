package pl.tmassalski.vetservice.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tmassalski.vetservice.api.user.UserRequest;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserCreatorClient userCreatorClient;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User registerNewUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setRole("USER");
        return userCreatorClient.register(user);
    }
}

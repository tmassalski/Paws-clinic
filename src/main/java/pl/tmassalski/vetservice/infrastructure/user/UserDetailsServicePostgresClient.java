package pl.tmassalski.vetservice.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.vetservice.domain.user.User;
import pl.tmassalski.vetservice.domain.user.UserCreatorClient;

@Service
@RequiredArgsConstructor
public class UserDetailsServicePostgresClient implements UserCreatorClient {

    private final UserRepository userRepository;

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }
}

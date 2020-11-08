package pl.tmassalski.vetservice.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.vetservice.domain.user.User;
import pl.tmassalski.vetservice.domain.user.UserUpdaterClient;


@Service
@RequiredArgsConstructor
class UserUpdaterPostgresClient implements UserUpdaterClient {

    private final UserRepository userRepository;

    @Override
    public void update(User user) {
        userRepository.save(user);
    }
}

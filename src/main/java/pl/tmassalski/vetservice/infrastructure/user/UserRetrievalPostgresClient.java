package pl.tmassalski.vetservice.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.vetservice.domain.user.exceptions.EmailNotFoundException;
import pl.tmassalski.vetservice.domain.user.User;
import pl.tmassalski.vetservice.domain.user.exceptions.UserNotFoundException;
import pl.tmassalski.vetservice.domain.user.UserRetrievalClient;

@RequiredArgsConstructor
@Service
class UserRetrievalPostgresClient implements UserRetrievalClient {

    private final UserRepository userRepository;

    @Override
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException(username));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()-> new EmailNotFoundException(email));
    }
}


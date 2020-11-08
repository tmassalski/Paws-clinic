package pl.tmassalski.vetservice.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.vetservice.domain.user.UserRetrievalClient;

@RequiredArgsConstructor
@Service
class UserRetrievalPostgresClient implements UserRetrievalClient {

    private final UserRepository userRepository;

    @Override
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}


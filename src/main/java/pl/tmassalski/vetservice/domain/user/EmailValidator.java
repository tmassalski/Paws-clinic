package pl.tmassalski.vetservice.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmailValidator {

    private final UserRetrievalClient userRetrievalClient;

    boolean validate(String email){
        return userRetrievalClient.emailExists(email);
    }
}
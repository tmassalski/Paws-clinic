package pl.tmassalski.vetservice.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class PasswordChanger {

    private final UserUpdaterClient userUpdaterClient;
    private final PasswordEncoder passwordEncoder;

    private String generateRandomPassword(int passwordLength){
        int lowerLimit = 48;
        int upperLimit = 122;
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            int nextRandomChar = lowerLimit
                    + (int)(random.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            builder.append((char)nextRandomChar);
        }
        return builder.toString();
    }

    String setRandomPassword(User user){
        String password = generateRandomPassword(8);
        user.setPassword(passwordEncoder.encode(password));
        userUpdaterClient.update(user);
        return password;
    }

    void updatePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userUpdaterClient.update(user);
    }
}

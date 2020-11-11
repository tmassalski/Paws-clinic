package pl.tmassalski.vetservice.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.vetservice.domain.mail.MailService;

import javax.mail.MessagingException;

@Service
@RequiredArgsConstructor
public class PasswordSender {

    private final MailService mailService;

    void sendPassword(User user, String password){

        String message = "Hi " + user.getUsername() + "!\nYou have requested to reset your password for your Paws Clinic account. Please use below password and change it once you log in.\n\nPassword: " + password;
        try {
            mailService.sendMail(user.getEmail(), "Password reset", message, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

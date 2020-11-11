package pl.tmassalski.vetservice.domain.token;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.tmassalski.vetservice.domain.mail.MailService;
import pl.tmassalski.vetservice.domain.user.User;

import javax.mail.MessagingException;

@Service
@RequiredArgsConstructor
class TokenSender {

    private final MailService mailService;

    void sendToken(Token token, User user) {

        String activationUrl = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("users/token")
                .replaceQueryParam("value", token.getValue())
                .toUriString();

        String message = "Hi " + user.getUsername() + "!\n\n To activate your account click the link below:\n" + activationUrl;
        try {
            mailService.sendMail(user.getEmail(), "Activate your account in Paws Clinic", message, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
package pl.tmassalski.vetservice.domain.token;

import lombok.Getter;
import lombok.Setter;
import pl.tmassalski.vetservice.domain.user.User;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @OneToOne
    private User user;

    static Token generate(User user) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setValue(tokenValue);
        token.setUser(user);
        return token;
    }
}
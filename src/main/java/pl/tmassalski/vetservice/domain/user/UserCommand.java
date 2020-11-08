package pl.tmassalski.vetservice.domain.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCommand {

    private String username;
    private String password;
    private String email;
}

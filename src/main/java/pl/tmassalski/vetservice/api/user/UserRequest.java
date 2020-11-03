package pl.tmassalski.vetservice.api.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRequest {

    @NotBlank
    String username;
    @NotBlank
    String password;
}

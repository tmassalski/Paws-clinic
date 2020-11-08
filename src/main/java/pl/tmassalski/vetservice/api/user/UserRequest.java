package pl.tmassalski.vetservice.api.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Email
    private String email;
}

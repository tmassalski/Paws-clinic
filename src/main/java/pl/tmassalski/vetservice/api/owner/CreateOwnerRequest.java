package pl.tmassalski.vetservice.api.owner;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
class CreateOwnerRequest {

    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotBlank
    String address;
    @NotBlank
    String city;
    @NotBlank
    String phone;
}

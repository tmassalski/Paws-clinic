package pl.tmassalski.vetservice.api.petType;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PetTypeRequest {

    @NotBlank(message = "Type name cannot be blank")
    String typeName;
}

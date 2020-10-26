package pl.tmassalski.vetservice.api.pet;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

@Getter
@Setter
@Value
public class CreatePetRequest {

    @NotBlank
    String name;
    @Past
    Date birthDate;
    @Min(1)
    Long petTypeId;
    @Min(1)
    Long petOwnerId;

}

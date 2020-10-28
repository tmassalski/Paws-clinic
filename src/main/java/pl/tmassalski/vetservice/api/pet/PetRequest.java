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
public class PetRequest {

    @NotBlank
    String name;
    @Past
    Date birthDate;
    @Min(value = 1, message = "Incorrect ID")
    Long petTypeId;
    @Min(value = 1, message = "Incorrect ID")
    Long petOwnerId;

}

package pl.tmassalski.vetservice.domain.pet;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PetCommand {

    String name;
    LocalDate birthDate;
    Long petTypeId;
    Long petOwnerId;
}

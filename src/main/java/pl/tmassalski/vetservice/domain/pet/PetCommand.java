package pl.tmassalski.vetservice.domain.pet;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PetCommand {

    String name;
    Date birthDate;
    Long petTypeId;
    Long petOwnerId;
}

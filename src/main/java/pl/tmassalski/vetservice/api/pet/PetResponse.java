package pl.tmassalski.vetservice.api.pet;

import lombok.Getter;
import lombok.Setter;
import pl.tmassalski.vetservice.api.petType.PetTypeResponse;
import pl.tmassalski.vetservice.api.visit.VisitResponse;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class PetResponse {

    Long id;
    String name;
    LocalDate birthDate;
    PetTypeResponse type;
    Long ownerId;
    Set<VisitResponse> visits;
}

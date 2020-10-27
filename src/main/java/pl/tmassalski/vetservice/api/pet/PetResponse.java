package pl.tmassalski.vetservice.api.pet;

import lombok.Getter;
import lombok.Setter;
import pl.tmassalski.vetservice.api.petType.PetTypeResponse;
import pl.tmassalski.vetservice.api.visit.VisitResponse;
import pl.tmassalski.vetservice.domain.visit.Visit;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class PetResponse {

    Long id;
    String name;
    Date birthDate;
    PetTypeResponse type;
    Long ownerId;
    Set<VisitResponse> visits;
}

package pl.tmassalski.vetservice.api.vet;

import lombok.Getter;
import lombok.Setter;
import pl.tmassalski.vetservice.api.specialty.SpecialtyResponse;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class VetResponse {

    Long id;
    String firstName;
    String lastName;
    Set<SpecialtyResponse> specialties = new HashSet<>();
}

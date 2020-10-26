package pl.tmassalski.vetservice.api.owner;

import lombok.Getter;
import lombok.Setter;
import pl.tmassalski.vetservice.api.pet.PetResponse;
import pl.tmassalski.vetservice.domain.pet.Pet;

import java.util.Set;

@Getter
@Setter
public class OwnerResponse {

    Long id;
    String firstName;
    String lastName;
    String address;
    String city;
    String phone;
    Set<PetResponse> pets;
}
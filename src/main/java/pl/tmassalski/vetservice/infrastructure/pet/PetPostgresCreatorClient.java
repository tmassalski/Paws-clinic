package pl.tmassalski.vetservice.infrastructure.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.pet.Pet;
import pl.tmassalski.vetservice.domain.pet.PetCreatorClient;

@Repository
@RequiredArgsConstructor
public class PetPostgresCreatorClient implements PetCreatorClient {

    private final PetRepository petRepository;

    @Override
    public void add(Pet pet) {
        petRepository.save(pet);
    }
}

package pl.tmassalski.vetservice.infrastructure.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.pet.Pet;
import pl.tmassalski.vetservice.domain.pet.PetUpdaterClient;

@Repository
@RequiredArgsConstructor
public class PetUpdaterPostgresClient implements PetUpdaterClient {

    private final PetRepository petRepository;

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void save(Pet pet) {
        petRepository.save(pet);
    }
}

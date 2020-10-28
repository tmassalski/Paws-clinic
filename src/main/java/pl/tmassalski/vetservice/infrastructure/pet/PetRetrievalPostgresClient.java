package pl.tmassalski.vetservice.infrastructure.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.pet.Pet;
import pl.tmassalski.vetservice.domain.pet.PetNotFoundException;
import pl.tmassalski.vetservice.domain.pet.PetRetrievalClient;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PetRetrievalPostgresClient implements PetRetrievalClient {

    private final PetRepository petRepository;

    @Override
    public Pet getById(Long id) {
        Optional<Pet> petOptional = petRepository.findById(id);
        return petOptional.orElseThrow(()->new PetNotFoundException(id));
    }

    @Override
    public List<Pet> getAll() {
        return petRepository.findAll();
    }
}

package pl.tmassalski.vetservice.infrastructure.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.pet.PetType;
import pl.tmassalski.vetservice.domain.pet.PetTypeCreatorClient;

@Repository
@RequiredArgsConstructor
public class PetTypePostgresCreatorClient implements PetTypeCreatorClient {

    private final PetTypeRepository petTypeRepository;

    @Override
    public PetType add(PetType petType) {
      return petTypeRepository.save(petType);
    }
}

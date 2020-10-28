package pl.tmassalski.vetservice.infrastructure.petType;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.petType.PetType;
import pl.tmassalski.vetservice.domain.petType.PetTypeCreatorClient;

@Repository
@RequiredArgsConstructor
public class PetTypePostgresCreatorClient implements PetTypeCreatorClient {

    private final PetTypeRepository petTypeRepository;

    @Override
    public PetType add(PetType petType) {
      return petTypeRepository.save(petType);
    }
}

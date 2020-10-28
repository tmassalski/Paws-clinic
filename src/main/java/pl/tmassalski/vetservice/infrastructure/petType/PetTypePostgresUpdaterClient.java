package pl.tmassalski.vetservice.infrastructure.petType;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.petType.PetType;
import pl.tmassalski.vetservice.domain.petType.PetTypeUpdaterClient;

@Repository
@RequiredArgsConstructor
public class PetTypePostgresUpdaterClient implements PetTypeUpdaterClient {

    private final PetTypeRepository petTypeRepository;

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void save(PetType petType) {
        petTypeRepository.save(petType);
    }
}

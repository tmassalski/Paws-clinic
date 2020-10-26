package pl.tmassalski.vetservice.infrastructure.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.pet.PetType;
import pl.tmassalski.vetservice.domain.pet.PetTypeUpdaterClient;

@Repository
@RequiredArgsConstructor
public class PetTypePostgresUpdaterClient implements PetTypeUpdaterClient {

    private final PetTypeRepository petTypeRepository;

    @Override
    public void delete(Long id) {
        petTypeRepository.deleteById(id);
    }

    @Override
    public void save(PetType petType) {
        petTypeRepository.save(petType);
    }
}

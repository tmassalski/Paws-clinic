package pl.tmassalski.vetservice.infrastructure.petType;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.petType.PetType;
import pl.tmassalski.vetservice.domain.petType.PetTypeNotFoundException;
import pl.tmassalski.vetservice.domain.petType.PetTypeRetrievalClient;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PetTypePostgresRetrievalClient implements PetTypeRetrievalClient {

    private final PetTypeRepository petTypeRepository;

    @Override
    public PetType getById(Long id) {
        Optional<PetType> petTypeOptional = petTypeRepository.findById(id);
        return petTypeOptional.orElseThrow(() -> new PetTypeNotFoundException(id));
    }

    @Override
    public List<PetType> getAll() {
        return petTypeRepository.findAll();
    }
}

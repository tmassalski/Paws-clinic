package pl.tmassalski.vetservice.infrastructure.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.pet.PetType;
import pl.tmassalski.vetservice.domain.pet.PetTypeException;
import pl.tmassalski.vetservice.domain.pet.PetTypeRetrievalClient;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PetTypePostgresRetrievalClient implements PetTypeRetrievalClient {

    private final PetTypeRepository petTypeRepository;

    @Override
    public PetType getById(Long id) {
        Optional<PetType> petTypeOptional = petTypeRepository.findById(id);
        //todo
        return petTypeOptional.orElseThrow(PetTypeException::idNotFound);
    }

    @Override
    public List<PetType> getAll() {
        return petTypeRepository.findAll();
    }
}

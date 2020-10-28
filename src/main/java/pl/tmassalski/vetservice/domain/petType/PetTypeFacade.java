package pl.tmassalski.vetservice.domain.petType;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetTypeFacade {

    private final PetTypeCreatorClient petTypeCreatorClient;
    private final PetTypeRetrievalClient petTypeRetrievalClient;
    private final PetTypeUpdaterClient petTypeUpdaterClient;

    public PetType getPetType(Long id) {
        return petTypeRetrievalClient.getById(id);
    }

    public List<PetType> getAll() {
        return petTypeRetrievalClient.getAll();
    }

    public PetType addPetType(PetType type) {
        return petTypeCreatorClient.add(type);
    }

    @Transactional
    public void delete(Long id) {
        PetType petType = getPetType(id);
        petTypeUpdaterClient.delete(petType);
    }

    @Transactional
    public PetType update(PetType petType, Long id) {
        PetType retrievedPetType = getPetType(id);
        retrievedPetType.setTypeName(petType.getTypeName());
        petTypeUpdaterClient.save(retrievedPetType);
        return retrievedPetType;
    }
}

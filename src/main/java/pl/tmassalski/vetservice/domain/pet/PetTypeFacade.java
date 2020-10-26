package pl.tmassalski.vetservice.domain.pet;

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
    public boolean delete(Long id) {
        PetType petType = getPetType(id);
        if (petType != null) {
            petTypeUpdaterClient.delete(id);
            return true;
        }
        return false;
    }

    @Transactional
    public PetType update(PetType petType, Long id) {
        PetType retrievedPetType = getPetType(id);
        if (retrievedPetType != null) {
            retrievedPetType.setTypeName(petType.getTypeName());
            petTypeUpdaterClient.save(retrievedPetType);
            return retrievedPetType;
        }
        return null;
    }
}

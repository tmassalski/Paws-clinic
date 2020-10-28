package pl.tmassalski.vetservice.domain.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tmassalski.vetservice.domain.owner.Owner;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PetFacade {

    private final PetCreator petCreator;
    private final PetRetrievalClient petRetrievalClient;
    private final PetUpdaterClient petUpdaterClient;
    private final PetUpdater petUpdater;

    public Pet createPet(PetCommand petCommand) {
        return petCreator.createPet(petCommand);
    }

    public Pet getPet(Long id) {
        return petRetrievalClient.getById(id);
    }

    public Collection<Pet> getAll() {
        return petRetrievalClient.getAll();
    }

    @Transactional
    public void delete(Long petId) {
        Pet pet = getPet(petId);
        petUpdaterClient.delete(pet);
    }

    public Pet update(PetCommand command, Long petId) {
        Pet retrievedPet = petRetrievalClient.getById(petId);
        return petUpdater.updatePet(retrievedPet, command);
    }
}

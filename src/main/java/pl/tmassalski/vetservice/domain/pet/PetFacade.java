package pl.tmassalski.vetservice.domain.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PetFacade {

    private final PetCreator petCreator;
    private final PetRetrievalClient petRetrievalClient;

    public Pet createPet(PetCommand petCommand) {
        return petCreator.createPet(petCommand);
    }

    public Pet getPet(Long id) {
        return petRetrievalClient.getById(id);
    }

    public Collection<Pet> getAll() {
        return petRetrievalClient.getAll();
    }
}

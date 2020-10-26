package pl.tmassalski.vetservice.domain.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tmassalski.vetservice.domain.owner.Owner;
import pl.tmassalski.vetservice.domain.owner.OwnerFacade;

@Service
@RequiredArgsConstructor
public class PetCreator {

    private final OwnerFacade ownerFacade;
    private final PetTypeFacade petTypeFacade;
    private final PetCreatorClient petCreatorClient;

    @Transactional
    Pet createPet(PetCommand petCommand) {
        Pet pet = Pet.generate(petCommand);
        PetType petType = petTypeFacade.getPetType(petCommand.getPetTypeId());
        pet.setType(petType);
        Owner owner = ownerFacade.getOwner(petCommand.getPetOwnerId());
        owner.addPet(pet);
        petCreatorClient.add(pet);
        return pet;
    }
}

package pl.tmassalski.vetservice.domain.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tmassalski.vetservice.domain.owner.Owner;
import pl.tmassalski.vetservice.domain.owner.OwnerFacade;
import pl.tmassalski.vetservice.domain.petType.PetType;
import pl.tmassalski.vetservice.domain.petType.PetTypeFacade;

@Service
@RequiredArgsConstructor
public class PetUpdater {

    private final OwnerFacade ownerFacade;
    private final PetTypeFacade petTypeFacade;
    private final PetUpdaterClient petUpdaterClient;

    @Transactional
    Pet updatePet(Pet retrievedPet,PetCommand petCommand) {
        retrievedPet.setName(petCommand.getName());
        retrievedPet.setBirthDate(petCommand.getBirthDate());
        PetType updatedPetType = petTypeFacade.getPetType(petCommand.getPetTypeId());
        retrievedPet.setType(updatedPetType);
        Owner updatedOwner = ownerFacade.getOwner(petCommand.getPetOwnerId());
        updatedOwner.addPet(retrievedPet);
        petUpdaterClient.save(retrievedPet);
        return retrievedPet;
    }
}

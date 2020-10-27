package pl.tmassalski.vetservice.domain.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tmassalski.vetservice.domain.pet.Pet;
import pl.tmassalski.vetservice.domain.pet.PetFacade;
import pl.tmassalski.vetservice.domain.pet.PetUpdater;

@Service
@RequiredArgsConstructor
public class VisitUpdater {

    private final PetFacade petFacade;
    private final VisitUpdaterClient visitUpdaterClient;

    @Transactional
    public Visit updateVisit(Visit retrievedVisit, VisitCommand command) {
        retrievedVisit.setDate(command.getDate());
        retrievedVisit.setDescription(command.getDescription());
        Pet pet = petFacade.getPet(command.getPetId());
        pet.addVisit(retrievedVisit);
        visitUpdaterClient.save(retrievedVisit);
        return retrievedVisit;
    }
}

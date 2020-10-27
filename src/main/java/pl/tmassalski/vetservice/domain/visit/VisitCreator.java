package pl.tmassalski.vetservice.domain.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tmassalski.vetservice.domain.pet.Pet;
import pl.tmassalski.vetservice.domain.pet.PetFacade;

@Service
@RequiredArgsConstructor
public class VisitCreator {

    private final VisitCreatorClient visitCreatorClient;
    private final PetFacade petFacade;

    @Transactional
    public Visit create(VisitCommand command) {
        Visit visit = Visit.generate(command);
        Pet pet = petFacade.getPet(command.getPetId());
        pet.addVisit(visit);
        visitCreatorClient.add(visit);
        return visit;
    }
}

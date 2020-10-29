package pl.tmassalski.vetservice.domain.vet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.vetservice.domain.specialty.SpecialtyFacade;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VetUpdater {

    private final VetUpdaterClient vetUpdaterClient;
    private final SpecialtyFacade specialtyFacade;

    Vet updateVet(Vet retrievedVet, VetCommand command) {
        retrievedVet.setFirstName(command.getFirstName());
        retrievedVet.setLastName(command.getLastName());
        retrievedVet.setSpecialties(
                command.getSpecialtyId().stream()
                        .map(specialtyFacade::getSpecialty)
                        .collect(Collectors.toSet()));
        vetUpdaterClient.update(retrievedVet);
        return retrievedVet;
    }
}

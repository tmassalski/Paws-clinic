package pl.tmassalski.vetservice.domain.vet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tmassalski.vetservice.domain.specialty.SpecialtyFacade;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class VetCreator {

    private final SpecialtyFacade specialtyFacade;
    private final VetCreatorClient vetCreatorClient;

    @Transactional
    Vet create(VetCommand command) {
        Vet vet = Vet.generate(command);
        vet.setSpecialties(command.getSpecialtyId().stream()
                .map(specialtyFacade::getSpecialty)
                .collect(Collectors.toSet()));
        return vetCreatorClient.create(vet);
    }
}

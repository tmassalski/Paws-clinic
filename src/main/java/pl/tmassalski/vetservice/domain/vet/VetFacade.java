package pl.tmassalski.vetservice.domain.vet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class VetFacade {

    private final VetCreator vetCreator;
    private final VetRetrievalClient vetRetrievalClient;
    private final VetUpdaterClient vetUpdaterClient;
    private final VetUpdater vetUpdater;

    public Collection<Vet> getAll() {
        return vetRetrievalClient.getAll();
    }

    public Vet getVet(Long vetId) {
        return vetRetrievalClient.getById(vetId);
    }

    public Vet createVet(VetCommand command) {
        return vetCreator.create(command);
    }

    public void delete(Long vetId) {
        Vet vet = getVet(vetId);
        vetUpdaterClient.delete(vet);
    }

    @Transactional
    public Vet update(VetCommand command, Long vetId) {
        Vet retrievedVet = getVet(vetId);
        return vetUpdater.updateVet(retrievedVet, command);
    }
}

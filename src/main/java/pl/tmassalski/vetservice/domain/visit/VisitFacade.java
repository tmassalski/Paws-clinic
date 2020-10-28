package pl.tmassalski.vetservice.domain.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitFacade {

    private final VisitRetrievalClient visitRetrievalClient;
    private final VisitUpdaterClient visitUpdaterClient;
    private final VisitCreator visitCreator;
    private final VisitUpdater visitUpdater;

    public List<Visit> getAll() {
        return visitRetrievalClient.getAll();
    }

    public Visit getVisit(Long visitId) {
        return visitRetrievalClient.getById(visitId);
    }

    public Visit createVisit(VisitCommand command) {
        return visitCreator.create(command);
    }

    @Transactional
    public void delete(Long visitId) {
        Visit visit = getVisit(visitId);
        visitUpdaterClient.delete(visit);
    }

    @Transactional
    public Visit update(VisitCommand command, Long visitId) {
        Visit retrievedVisit = getVisit(visitId);
        return visitUpdater.updateVisit(retrievedVisit, command);
    }

    public List<Visit> getByPetId(Long petId) {
        return visitRetrievalClient.getByPetId(petId);
    }
}

package pl.tmassalski.vetservice.infrastructure.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.visit.Visit;
import pl.tmassalski.vetservice.domain.visit.VisitUpdaterClient;

@Repository
@RequiredArgsConstructor
public class VisitUpdaterPostgresClient implements VisitUpdaterClient {

    private final VisitRepository visitRepository;

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void save(Visit visit) {
        visitRepository.save(visit);
    }
}

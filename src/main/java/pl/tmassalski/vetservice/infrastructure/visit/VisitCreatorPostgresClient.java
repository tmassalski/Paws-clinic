package pl.tmassalski.vetservice.infrastructure.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.visit.Visit;
import pl.tmassalski.vetservice.domain.visit.VisitCreatorClient;

@Repository
@RequiredArgsConstructor
public class VisitCreatorPostgresClient implements VisitCreatorClient {

    private final VisitRepository visitRepository;

    @Override
    public Visit add(Visit visit) {
        return visitRepository.save(visit);
    }
}

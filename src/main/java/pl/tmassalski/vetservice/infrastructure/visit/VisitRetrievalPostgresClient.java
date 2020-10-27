package pl.tmassalski.vetservice.infrastructure.visit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.visit.Visit;
import pl.tmassalski.vetservice.domain.visit.VisitRetrievalClient;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VisitRetrievalPostgresClient implements VisitRetrievalClient {

    private final VisitRepository visitRepository;

    @Override
    public List<Visit> getAll() {
        return visitRepository.findAll();
    }

    @Override
    public Visit getById(Long id) {
        Optional<Visit> visitOptional = visitRepository.findById(id);
        return visitOptional.orElseThrow();
    }

    @Override
    public List<Visit> getByPetId(Long petId) {
        return visitRepository.findAllByPetId(petId);
    }
}

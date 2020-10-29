package pl.tmassalski.vetservice.infrastructure.vet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.vet.Vet;
import pl.tmassalski.vetservice.domain.vet.VetNotFoundException;
import pl.tmassalski.vetservice.domain.vet.VetRetrievalClient;

import java.util.Collection;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VetRetrievalPostgresClient implements VetRetrievalClient {

    private final VetRepository vetRepository;

    @Override
    public Collection<Vet> getAll() {
        return vetRepository.findAll();
    }

    @Override
    public Vet getById(Long vetId) {
        Optional<Vet> vetOptional = vetRepository.findById(vetId);
        return vetOptional.orElseThrow(() -> new VetNotFoundException(vetId));
    }
}

package pl.tmassalski.vetservice.infrastructure.vet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.vet.Vet;
import pl.tmassalski.vetservice.domain.vet.VetCreatorClient;
@Repository
@RequiredArgsConstructor
public class VetCreatorPostgresClient implements VetCreatorClient {

    private final VetRepository vetRepository;

    @Override
    public Vet create(Vet vet) {
        return vetRepository.save(vet);
    }
}

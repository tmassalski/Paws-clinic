package pl.tmassalski.vetservice.infrastructure.vet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.vet.Vet;
import pl.tmassalski.vetservice.domain.vet.VetUpdaterClient;

@Repository
@RequiredArgsConstructor
public class VetUpdaterPostgresClient implements VetUpdaterClient {

    private final VetRepository vetRepository;

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void update(Vet vet) {
        vetRepository.save(vet);
    }
}

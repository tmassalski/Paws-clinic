package pl.tmassalski.vetservice.infrastructure.owner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.owner.Owner;
import pl.tmassalski.vetservice.domain.owner.OwnerRetrievalClient;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OwnerRetrievalPostgresClient implements OwnerRetrievalClient {

    private final OwnerRepository ownerRepository;

    @Override
    public Owner getById(Long id) {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        return ownerOptional.orElseThrow();
    }

    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }
}

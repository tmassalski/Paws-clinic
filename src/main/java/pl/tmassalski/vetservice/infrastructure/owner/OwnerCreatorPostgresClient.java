package pl.tmassalski.vetservice.infrastructure.owner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.owner.Owner;
import pl.tmassalski.vetservice.domain.owner.OwnerCreatorClient;

@Repository
@RequiredArgsConstructor
public class OwnerCreatorPostgresClient implements OwnerCreatorClient {

    private final OwnerRepository ownerRepository;

    @Override
    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }
}

package pl.tmassalski.vetservice.infrastructure.owner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.owner.Owner;
import pl.tmassalski.vetservice.domain.owner.OwnerUpdaterClient;

@Repository
@RequiredArgsConstructor
public class OwnerUpdaterPostgresClient implements OwnerUpdaterClient {

    private final OwnerRepository ownerRepository;

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void save(Owner owner) {
        ownerRepository.save(owner);
    }
}

package pl.tmassalski.vetservice.infrastructure.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tmassalski.vetservice.domain.owner.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

package pl.tmassalski.vetservice.infrastructure.vet;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tmassalski.vetservice.domain.vet.Vet;

public interface VetRepository extends JpaRepository<Vet, Long> {
}

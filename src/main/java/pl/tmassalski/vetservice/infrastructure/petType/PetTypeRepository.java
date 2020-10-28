package pl.tmassalski.vetservice.infrastructure.petType;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tmassalski.vetservice.domain.petType.PetType;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}

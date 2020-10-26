package pl.tmassalski.vetservice.infrastructure.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tmassalski.vetservice.domain.pet.PetType;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}

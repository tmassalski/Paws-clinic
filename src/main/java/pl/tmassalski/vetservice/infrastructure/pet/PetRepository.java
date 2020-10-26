package pl.tmassalski.vetservice.infrastructure.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tmassalski.vetservice.domain.pet.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}

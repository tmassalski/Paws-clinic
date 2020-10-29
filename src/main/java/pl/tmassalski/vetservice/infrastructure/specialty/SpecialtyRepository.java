package pl.tmassalski.vetservice.infrastructure.specialty;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tmassalski.vetservice.domain.specialty.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}

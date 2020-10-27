package pl.tmassalski.vetservice.infrastructure.visit;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tmassalski.vetservice.domain.visit.Visit;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findAllByPetId(Long id);
}

package pl.tmassalski.vetservice.infrastructure.specialty;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.specialty.Specialty;
import pl.tmassalski.vetservice.domain.specialty.SpecialtyUpdaterClient;

@Repository
@RequiredArgsConstructor
public class SpecialtyUpdaterPostgresClient implements SpecialtyUpdaterClient {

    private final SpecialtyRepository specialtyRepository;

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }

    @Override
    public void save(Specialty specialty) {
        specialtyRepository.save(specialty);
    }
}

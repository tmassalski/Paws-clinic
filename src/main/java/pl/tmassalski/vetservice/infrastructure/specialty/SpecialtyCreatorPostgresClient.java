package pl.tmassalski.vetservice.infrastructure.specialty;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.specialty.Specialty;
import pl.tmassalski.vetservice.domain.specialty.SpecialtyCreatorClient;

@Repository
@RequiredArgsConstructor
public class SpecialtyCreatorPostgresClient implements SpecialtyCreatorClient {

    private final SpecialtyRepository specialtyRepository;

    @Override
    public Specialty add(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }
}

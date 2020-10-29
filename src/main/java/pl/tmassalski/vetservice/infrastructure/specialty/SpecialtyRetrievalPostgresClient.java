package pl.tmassalski.vetservice.infrastructure.specialty;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.tmassalski.vetservice.domain.specialty.Specialty;
import pl.tmassalski.vetservice.domain.specialty.SpecialtyNotFoundException;
import pl.tmassalski.vetservice.domain.specialty.SpecialtyRetrievalClient;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SpecialtyRetrievalPostgresClient implements SpecialtyRetrievalClient {

    private final SpecialtyRepository specialtyRepository;

    @Override
    public Specialty getById(Long id) {
        Optional<Specialty> specialtyOptional =  specialtyRepository.findById(id);
        return specialtyOptional.orElseThrow(()-> new SpecialtyNotFoundException(id));
    }

    @Override
    public List<Specialty> getAll() {
        return specialtyRepository.findAll();
    }
}

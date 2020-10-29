package pl.tmassalski.vetservice.domain.specialty;

import java.util.List;

public interface SpecialtyRetrievalClient {
    Specialty getById(Long id);
    List<Specialty> getAll();
}

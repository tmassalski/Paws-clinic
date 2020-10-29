package pl.tmassalski.vetservice.domain.specialty;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialtyFacade {

    private final SpecialtyCreatorClient specialtyCreatorClient;
    private final SpecialtyRetrievalClient specialtyRetrievalClient;
    private final SpecialtyUpdaterClient specialtyUpdaterClient;

    public Specialty getSpecialty(Long id) {
        return specialtyRetrievalClient.getById(id);
    }

    public List<Specialty> getAll() {
        return specialtyRetrievalClient.getAll();
    }

    public Specialty addSpecialty(Specialty specialty) {
        return specialtyCreatorClient.add(specialty);
    }

    @Transactional
    public void delete(Long id) {
        Specialty specialty = getSpecialty(id);
        specialtyUpdaterClient.delete(specialty);
    }

    @Transactional
    public Specialty update(Specialty specialty, Long id) {
        Specialty retrievedSpecialty = getSpecialty(id);
        retrievedSpecialty.setSpecialtyName(specialty.getSpecialtyName());
        specialtyUpdaterClient.save(retrievedSpecialty);
        return retrievedSpecialty;
    }
}

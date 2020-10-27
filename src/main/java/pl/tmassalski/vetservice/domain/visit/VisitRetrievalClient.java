package pl.tmassalski.vetservice.domain.visit;

import java.util.List;

public interface VisitRetrievalClient {

    List<Visit> getAll();
    Visit getById(Long id);
    List<Visit> getByPetId(Long petId);
}

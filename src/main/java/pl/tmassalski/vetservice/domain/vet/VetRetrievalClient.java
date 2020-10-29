package pl.tmassalski.vetservice.domain.vet;

import java.util.Collection;

public interface VetRetrievalClient {

    Collection<Vet> getAll();
    Vet getById(Long vetId);
}

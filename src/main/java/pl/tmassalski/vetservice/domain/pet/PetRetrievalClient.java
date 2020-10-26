package pl.tmassalski.vetservice.domain.pet;

import java.util.List;

public interface PetRetrievalClient {

    Pet getById(Long id);
    List<Pet>getAll();
}

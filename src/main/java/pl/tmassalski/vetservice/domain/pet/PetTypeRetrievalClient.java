package pl.tmassalski.vetservice.domain.pet;

import java.util.List;

public interface PetTypeRetrievalClient {

    PetType getById(Long id);
    List<PetType> getAll();

}

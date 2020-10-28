package pl.tmassalski.vetservice.domain.petType;

import java.util.List;

public interface PetTypeRetrievalClient {

    PetType getById(Long id);
    List<PetType> getAll();

}

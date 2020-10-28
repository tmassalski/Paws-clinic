package pl.tmassalski.vetservice.domain.petType;

public interface PetTypeUpdaterClient {

    void delete(PetType petType);
    void save(PetType petType);
}

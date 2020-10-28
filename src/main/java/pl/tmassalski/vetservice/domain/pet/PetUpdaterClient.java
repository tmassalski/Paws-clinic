package pl.tmassalski.vetservice.domain.pet;

public interface PetUpdaterClient {

    void delete(Pet pet);
    void save(Pet pet);
}

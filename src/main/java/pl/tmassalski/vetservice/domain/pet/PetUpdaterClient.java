package pl.tmassalski.vetservice.domain.pet;

public interface PetUpdaterClient {

    void delete(Long petId);
    void save(Pet pet);
}

package pl.tmassalski.vetservice.domain.pet;

public interface PetTypeUpdaterClient {


    void delete(Long id);
    void save(PetType petType);
}

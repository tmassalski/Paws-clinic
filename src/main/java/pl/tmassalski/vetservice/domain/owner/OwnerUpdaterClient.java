package pl.tmassalski.vetservice.domain.owner;

public interface OwnerUpdaterClient {

    void delete(Long id);
    void save(Owner owner);
}

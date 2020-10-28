package pl.tmassalski.vetservice.domain.owner;

public interface OwnerUpdaterClient {

    void delete(Owner owner);
    void save(Owner owner);
}

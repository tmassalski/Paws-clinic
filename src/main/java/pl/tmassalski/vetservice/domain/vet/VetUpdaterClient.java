package pl.tmassalski.vetservice.domain.vet;

public interface VetUpdaterClient {

    void delete(Vet vet);
    void update(Vet vet);
}

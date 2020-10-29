package pl.tmassalski.vetservice.domain.vet;

public class VetNotFoundException extends RuntimeException {
    public VetNotFoundException(Long id) {
        super("Can't find Vet with [id]: " + id);
    }
}

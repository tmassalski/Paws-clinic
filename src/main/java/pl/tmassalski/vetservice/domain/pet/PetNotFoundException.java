package pl.tmassalski.vetservice.domain.pet;

public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException(Long id) {
        super("Can't find Pet with [id]: " +id);
    }
}

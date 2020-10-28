package pl.tmassalski.vetservice.domain.petType;

public class PetTypeNotFoundException extends RuntimeException {

    public PetTypeNotFoundException(long id) {
        super("Can't find Pet Type with [id]: " +id);
    }
}

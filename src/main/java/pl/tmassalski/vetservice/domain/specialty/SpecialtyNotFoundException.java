package pl.tmassalski.vetservice.domain.specialty;

public class SpecialtyNotFoundException extends RuntimeException {

    public SpecialtyNotFoundException(Long id) {
        super("Can't find Specialty with [id]: " +id);
    }
}

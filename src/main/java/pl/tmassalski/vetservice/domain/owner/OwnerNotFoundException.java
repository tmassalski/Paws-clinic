package pl.tmassalski.vetservice.domain.owner;

public class OwnerNotFoundException extends RuntimeException {

    public OwnerNotFoundException(Long id){
        super("Can't find owner with [id]: " +id);
    }
}

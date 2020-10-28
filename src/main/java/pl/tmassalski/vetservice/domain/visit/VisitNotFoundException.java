package pl.tmassalski.vetservice.domain.visit;

public class VisitNotFoundException extends RuntimeException {

    public VisitNotFoundException(long id) {
        super("Can't find visit with [id]: " +id);
    }
}

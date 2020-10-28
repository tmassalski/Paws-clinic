package pl.tmassalski.vetservice.domain.visit;

public interface VisitUpdaterClient {
    void delete(Visit visit);
    void save(Visit visit);
}

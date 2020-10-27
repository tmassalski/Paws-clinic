package pl.tmassalski.vetservice.domain.visit;

public interface VisitUpdaterClient {
    void delete(Long visitId);
    void save(Visit visit);
}

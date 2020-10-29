package pl.tmassalski.vetservice.domain.specialty;

public interface SpecialtyUpdaterClient {
    void delete(Specialty specialty);
    void save(Specialty specialty);
}

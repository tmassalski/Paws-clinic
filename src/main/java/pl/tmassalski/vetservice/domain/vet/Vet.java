package pl.tmassalski.vetservice.domain.vet;

import lombok.*;
import pl.tmassalski.vetservice.domain.specialty.Specialty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany()
    @JoinTable(
            name = "vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    Set<Specialty> specialties = new HashSet<>();

    static Vet generate(VetCommand command) {
        return Vet.builder()
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .specialties(new HashSet<>())
                .build();
    }
}

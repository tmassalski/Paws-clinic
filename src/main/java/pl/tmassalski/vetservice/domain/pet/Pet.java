package pl.tmassalski.vetservice.domain.pet;

import lombok.*;
import pl.tmassalski.vetservice.domain.owner.Owner;
import pl.tmassalski.vetservice.domain.visit.Visit;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Date birthDate;

    @ManyToOne
    @JoinColumn(name = "petType_id")
    PetType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owner owner;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    Set<Visit> visits = new HashSet<>();

    public void addVisit(Visit visit) {
        if (visits == null) {
            visits = new HashSet<>();
        }
        visits.add(visit);
        visit.setPet(this);
    }

    static Pet generate(PetCommand petCommand) {
        return Pet.builder()
                .name(petCommand.getName())
                .birthDate(petCommand.getBirthDate())
                .build();
    }
}

package pl.tmassalski.vetservice.domain.visit;

import lombok.*;
import pl.tmassalski.vetservice.domain.pet.Pet;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "visit_sequence")
    @SequenceGenerator(name = "visit_sequence", initialValue = 7)
    Long id;

    LocalDate date;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    @Setter
    Pet pet;

    String description;

    static Visit generate(VisitCommand command) {
        return Visit.builder()
                .date(command.getDate())
                .description(command.getDescription())
                .build();
    }
}

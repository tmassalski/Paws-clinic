package pl.tmassalski.vetservice.domain.visit;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.tmassalski.vetservice.domain.pet.Pet;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    @Id
    @GeneratedValue
    Long id;
    Date date;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    Pet pet;

    String description;
}

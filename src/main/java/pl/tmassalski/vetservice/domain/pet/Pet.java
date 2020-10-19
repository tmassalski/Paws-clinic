package pl.tmassalski.vetservice.domain.pet;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.tmassalski.vetservice.domain.owner.Owner;
import pl.tmassalski.vetservice.domain.visit.Visit;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Date birthDate;
    PetType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owner owner;

    @OneToMany
    Set<Visit> visits;

}

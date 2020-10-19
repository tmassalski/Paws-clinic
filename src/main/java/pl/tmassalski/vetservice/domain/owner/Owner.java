package pl.tmassalski.vetservice.domain.owner;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.tmassalski.vetservice.domain.pet.Pet;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;
    String lastName;
    String address;
    String city;
    String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    Set<Pet> pets;
}

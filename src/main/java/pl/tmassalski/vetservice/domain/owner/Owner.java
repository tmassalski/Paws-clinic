package pl.tmassalski.vetservice.domain.owner;

import lombok.*;
import pl.tmassalski.vetservice.domain.pet.Pet;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "owner_sequence")
    @SequenceGenerator(name = "owner_sequence", initialValue = 5)
    Long id;

    String firstName;
    String lastName;
    String address;
    String city;
    String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    Set<Pet> pets;

    public void addPet(Pet pet) {
        if (pets == null) {
            pets = new HashSet<>();
        }
        pets.add(pet);
        pet.setOwner(this);
    }
}

package pl.tmassalski.vetservice.domain.petType;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pet_type_sequence")
    @SequenceGenerator(name = "pet_type_sequence", initialValue = 14)
    Long id;
    String typeName;

}

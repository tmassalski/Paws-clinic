package pl.tmassalski.vetservice.domain.petType;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String typeName;

}

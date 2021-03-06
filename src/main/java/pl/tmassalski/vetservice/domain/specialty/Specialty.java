package pl.tmassalski.vetservice.domain.specialty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.tmassalski.vetservice.domain.vet.Vet;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "specialty_sequence")
    @SequenceGenerator(name = "specialty_sequence", initialValue = 7)
    private Long id;
    private String specialtyName;
}

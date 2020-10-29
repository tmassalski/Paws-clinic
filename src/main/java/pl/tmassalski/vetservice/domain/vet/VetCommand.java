package pl.tmassalski.vetservice.domain.vet;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VetCommand {

    private String firstName;
    private String lastName;
    private List<Long> specialtyId = new ArrayList<>();
}

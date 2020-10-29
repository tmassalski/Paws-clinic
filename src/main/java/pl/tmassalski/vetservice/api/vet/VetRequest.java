package pl.tmassalski.vetservice.api.vet;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
class VetRequest {

    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    List<Long> specialtyId = new ArrayList<>();
}

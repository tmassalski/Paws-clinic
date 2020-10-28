package pl.tmassalski.vetservice.api.visit;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VisitResponse {

    Long id;
    LocalDate date;
    Long petId;
    String description;
}

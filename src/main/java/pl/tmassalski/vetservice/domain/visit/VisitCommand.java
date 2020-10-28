package pl.tmassalski.vetservice.domain.visit;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VisitCommand {

    LocalDate date;
    Long petId;
    String description;
}

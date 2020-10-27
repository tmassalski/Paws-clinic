package pl.tmassalski.vetservice.domain.visit;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VisitCommand {

    Date date;
    Long petId;
    String description;
}

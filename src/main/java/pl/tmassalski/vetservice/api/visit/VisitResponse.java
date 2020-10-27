package pl.tmassalski.vetservice.api.visit;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VisitResponse {

    Long id;
    Date date;
    Long petId;
    String description;
}

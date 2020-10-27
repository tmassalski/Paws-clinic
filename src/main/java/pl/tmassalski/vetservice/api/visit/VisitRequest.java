package pl.tmassalski.vetservice.api.visit;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VisitRequest {

    Date date;
    Long petId;
    String description;
}

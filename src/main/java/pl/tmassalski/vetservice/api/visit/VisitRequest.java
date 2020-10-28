package pl.tmassalski.vetservice.api.visit;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Getter
@Setter
public class VisitRequest {

    @PastOrPresent
    Date date;
    @Min(1)
    Long petId;
    @NotBlank
    String description;
}

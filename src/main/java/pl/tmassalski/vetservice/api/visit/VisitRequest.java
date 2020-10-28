package pl.tmassalski.vetservice.api.visit;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Getter
@Setter
public class VisitRequest {

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    LocalDate date;
    @Min(1)
    Long petId;
    @NotBlank
    String description;
}

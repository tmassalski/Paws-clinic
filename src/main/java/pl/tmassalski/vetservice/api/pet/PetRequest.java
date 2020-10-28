package pl.tmassalski.vetservice.api.pet;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Getter
@Setter
class PetRequest {

    @NotBlank
    String name;
    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    LocalDate birthDate;
    @Min(value = 1, message = "Incorrect ID")
    Long petTypeId;
    @Min(value = 1, message = "Incorrect ID")
    Long petOwnerId;

}

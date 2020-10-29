package pl.tmassalski.vetservice.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.tmassalski.vetservice.domain.owner.OwnerNotFoundException;
import pl.tmassalski.vetservice.domain.pet.PetNotFoundException;
import pl.tmassalski.vetservice.domain.petType.PetTypeNotFoundException;
import pl.tmassalski.vetservice.domain.specialty.SpecialtyNotFoundException;
import pl.tmassalski.vetservice.domain.vet.VetNotFoundException;
import pl.tmassalski.vetservice.domain.visit.VisitNotFoundException;

@ControllerAdvice
class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler({
            OwnerNotFoundException.class,
            PetTypeNotFoundException.class,
            PetNotFoundException.class,
            VisitNotFoundException.class,
            VetNotFoundException.class,
            SpecialtyNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String objectNotFoundHandler(RuntimeException ex) {
        return ex.getMessage();
    }
}

package pl.tmassalski.vetservice.api.visit;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.tmassalski.vetservice.domain.visit.Visit;
import pl.tmassalski.vetservice.domain.visit.VisitCommand;
import pl.tmassalski.vetservice.domain.visit.VisitException;
import pl.tmassalski.vetservice.domain.visit.VisitFacade;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/visits")
@RequiredArgsConstructor
public class VisitController {

    private final VisitFacade visitFacade;
    private final ModelMapper modelMapper;

    @GetMapping
    @ResponseBody
    Collection<VisitResponse> getAll() {
        Collection<Visit> visits = visitFacade.getAll();
        return visits.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{visitId}")
    @ResponseBody
    VisitResponse getById(@PathVariable("visitId") Long visitId) {
        try {
            Visit visit = visitFacade.getVisit(visitId);
            return convertToDto(visit);
        } catch (VisitException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Visit id not found", e);
        }
    }

    @GetMapping(value ="/pets/{petId}")
    @ResponseBody
    Collection<VisitResponse> getByPetId(@PathVariable("petId") Long petId){
        Collection<Visit> visits = visitFacade.getByPetId(petId);
        return visits.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    VisitResponse create(@RequestBody @Valid VisitRequest request) {
        VisitCommand command = convertToCommand(request);
        Visit createdVisit = visitFacade.createVisit(command);
        return convertToDto(createdVisit);
    }

    @DeleteMapping(value = "/{visitId}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long visitId) {
        if (!visitFacade.delete(visitId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Visit id not found");
        }
    }

    @PutMapping(value = "/{visitId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    VisitResponse update(@PathVariable Long visitId, @RequestBody @Valid VisitRequest request) {
        VisitCommand command = convertToCommand(request);
        try {
            Visit updatedVisit = visitFacade.update(command, visitId);
            return convertToDto(updatedVisit);
        } catch (VisitException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Visit id not found", e);
        }
    }

    private VisitCommand convertToCommand(VisitRequest visitRequest) {
        return modelMapper.map(visitRequest, VisitCommand.class);
    }

    private VisitResponse convertToDto(Visit visit) {
        return modelMapper.map(visit, VisitResponse.class);
    }
}

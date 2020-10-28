package pl.tmassalski.vetservice.api.visit;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.tmassalski.vetservice.domain.visit.Visit;
import pl.tmassalski.vetservice.domain.visit.VisitCommand;
import pl.tmassalski.vetservice.domain.visit.VisitFacade;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/visits")
@RequiredArgsConstructor
class VisitController {

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
        Visit visit = visitFacade.getVisit(visitId);
        return convertToDto(visit);
    }

    @GetMapping(value = "/pets/{petId}")
    @ResponseBody
    Collection<VisitResponse> getByPetId(@PathVariable("petId") Long petId) {
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
        visitFacade.delete(visitId);
    }

    @PutMapping(value = "/{visitId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    VisitResponse update(@PathVariable Long visitId, @RequestBody @Valid VisitRequest request) {
        VisitCommand command = convertToCommand(request);
        Visit updatedVisit = visitFacade.update(command, visitId);
        return convertToDto(updatedVisit);
    }

    private VisitCommand convertToCommand(VisitRequest visitRequest) {
        return modelMapper.map(visitRequest, VisitCommand.class);
    }

    private VisitResponse convertToDto(Visit visit) {
        return modelMapper.map(visit, VisitResponse.class);
    }
}

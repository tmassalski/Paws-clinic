package pl.tmassalski.vetservice.api.vet;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.tmassalski.vetservice.domain.vet.Vet;
import pl.tmassalski.vetservice.domain.vet.VetCommand;
import pl.tmassalski.vetservice.domain.vet.VetFacade;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vets")
@RequiredArgsConstructor
class VetController {

    private final VetFacade vetFacade;
    private final ModelMapper modelMapper;

    @GetMapping
    @ResponseBody
    Collection<VetResponse> getAll() {
        Collection<Vet> vets = vetFacade.getAll();
        return vets.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{vetId}")
    @ResponseBody
    VetResponse getById(@PathVariable("vetId") Long vetId) {
        Vet vet = vetFacade.getVet(vetId);
        return convertToDto(vet);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    VetResponse create(@RequestBody @Valid VetRequest request) {
        VetCommand command = convertToCommand(request);
        Vet createdVet = vetFacade.createVet(command);
        return convertToDto(createdVet);
    }

    @DeleteMapping(value = "/{vetId}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long vetId) {
        vetFacade.delete(vetId);
    }

    @PutMapping(value = "/{vetId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    VetResponse update(@PathVariable Long vetId, @RequestBody @Valid VetRequest request) {
        VetCommand command = convertToCommand(request);
        Vet updatedVet = vetFacade.update(command, vetId);
        return convertToDto(updatedVet);
    }

    private VetCommand convertToCommand(VetRequest request) {
        return modelMapper.map(request, VetCommand.class);
    }

    private VetResponse convertToDto(Vet vet) {
        return modelMapper.map(vet, VetResponse.class);
    }
}
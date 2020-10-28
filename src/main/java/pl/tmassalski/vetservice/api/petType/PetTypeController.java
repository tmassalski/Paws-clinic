package pl.tmassalski.vetservice.api.petType;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.tmassalski.vetservice.domain.petType.PetType;
import pl.tmassalski.vetservice.domain.petType.PetTypeFacade;

import javax.validation.Valid;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pet-types")
@RequiredArgsConstructor
class PetTypeController {

    private final PetTypeFacade petTypeFacade;
    private final ModelMapper modelMapper;

    @GetMapping
    @ResponseBody
    Collection<PetTypeResponse> getAll() {
        Collection<PetType> petTypes = petTypeFacade.getAll();
        return petTypes.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{petTypeId}")
    @ResponseBody
    PetTypeResponse getById(@PathVariable("petTypeId") Long petTypeId) {
        PetType petType = petTypeFacade.getPetType(petTypeId);
        return convertToDto(petType);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    PetTypeResponse create(@RequestBody @Valid PetTypeRequest request) {
        PetType petType = convertToEntity(request);
        PetType createdPetType = petTypeFacade.addPetType(petType);
        return convertToDto(createdPetType);
    }

    @DeleteMapping(value = "/{petTypeId}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long petTypeId) {
        petTypeFacade.delete(petTypeId);
    }

    @PutMapping(value = "/{petTypeId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    PetTypeResponse update(@PathVariable Long petTypeId, @RequestBody @Valid PetTypeRequest request) {
        PetType petType = convertToEntity(request);
        PetType updatedPetType = petTypeFacade.update(petType, petTypeId);
        return convertToDto(updatedPetType);
    }

    private PetType convertToEntity(PetTypeRequest petTypeRequest) {
        return modelMapper.map(petTypeRequest, PetType.class);
    }

    private PetTypeResponse convertToDto(PetType petType) {
        return modelMapper.map(petType, PetTypeResponse.class);
    }
}

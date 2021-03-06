package pl.tmassalski.vetservice.api.pet;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.tmassalski.vetservice.domain.pet.Pet;
import pl.tmassalski.vetservice.domain.pet.PetCommand;
import pl.tmassalski.vetservice.domain.pet.PetFacade;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
class PetController {

    private final PetFacade petFacade;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    PetResponse create(@Valid @RequestBody PetRequest request) {
        PetCommand petCommand = convertToPetCommand(request);
        Pet createdPet = petFacade.createPet(petCommand);
        return convertToDto(createdPet);
    }

    @GetMapping(value = "/{petId}")
    @ResponseBody
    PetResponse getById(@PathVariable Long petId) {
        Pet pet = petFacade.getPet(petId);
        return convertToDto(pet);
    }

    @GetMapping
    @ResponseBody
    Collection<PetResponse> getAll() {
        Collection<Pet> pets = petFacade.getAll();
        return pets.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/{petId}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long petId) {
        petFacade.delete(petId);
    }

    @PutMapping(value = "/{petId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    PetResponse update(@PathVariable Long petId, @RequestBody @Valid PetRequest request) {
        PetCommand command = convertToPetCommand(request);
        Pet updatedPet = petFacade.update(command, petId);
        return convertToDto(updatedPet);
    }

    private PetCommand convertToPetCommand(PetRequest request) {
        return modelMapper.map(request, PetCommand.class);
    }

    private PetResponse convertToDto(Pet pet) {
        return modelMapper.map(pet, PetResponse.class);
    }
}

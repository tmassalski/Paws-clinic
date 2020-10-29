package pl.tmassalski.vetservice.api.specialty;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.tmassalski.vetservice.domain.specialty.Specialty;
import pl.tmassalski.vetservice.domain.specialty.SpecialtyFacade;


import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/specialties")
@RequiredArgsConstructor
public class SpecialtyController {

    private final SpecialtyFacade specialtyFacade;
    private final ModelMapper modelMapper;

    @GetMapping
    @ResponseBody
    Collection<SpecialtyResponse> getAll() {
        Collection<Specialty> specialties = specialtyFacade.getAll();
        return specialties.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{specialtyId}")
    @ResponseBody
    SpecialtyResponse getById(@PathVariable("specialtyId") Long specialtyId) {
        Specialty specialty = specialtyFacade.getSpecialty(specialtyId);
        return convertToDto(specialty);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    SpecialtyResponse create(@RequestBody @Valid SpecialtyRequest request) {
        Specialty specialty = convertToEntity(request);
        Specialty createdSpecialty = specialtyFacade.addSpecialty(specialty);
        return convertToDto(createdSpecialty);
    }

    @DeleteMapping(value = "/{specialtyId}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long specialtyId) {
        specialtyFacade.delete(specialtyId);
    }

    @PutMapping(value = "/{specialtyId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    SpecialtyResponse update(@PathVariable Long specialtyId, @RequestBody @Valid SpecialtyRequest request) {
        Specialty specialty = convertToEntity(request);
        Specialty updatedSpecialty = specialtyFacade.update(specialty, specialtyId);
        return convertToDto(updatedSpecialty);
    }

    private Specialty convertToEntity(SpecialtyRequest request) {
        return modelMapper.map(request, Specialty.class);
    }

    private SpecialtyResponse convertToDto(Specialty specialty) {
        return modelMapper.map(specialty, SpecialtyResponse.class);
    }
}
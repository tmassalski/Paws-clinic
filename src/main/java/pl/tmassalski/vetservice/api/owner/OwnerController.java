package pl.tmassalski.vetservice.api.owner;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.tmassalski.vetservice.domain.owner.Owner;
import pl.tmassalski.vetservice.domain.owner.OwnerFacade;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final ModelMapper modelMapper;
    private final OwnerFacade ownerFacade;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    OwnerResponse create(@RequestBody @Valid CreateOwnerRequest request) {
        Owner owner = convertToEntity(request);
        Owner createdOwner = ownerFacade.createOwner(owner);
        return convertToDto(createdOwner);
    }

    @GetMapping(value = "/{ownerId}")
    @ResponseBody
    OwnerResponse getById(@PathVariable Long ownerId) {
        Owner owner = ownerFacade.getOwner(ownerId);
        return convertToDto(owner);
    }

    @GetMapping
    @ResponseBody
    Collection<OwnerResponse> getAll() {
        Collection<Owner> owners = ownerFacade.getAll();
        return owners.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private Owner convertToEntity(CreateOwnerRequest request) {
        return modelMapper.map(request, Owner.class);
    }

    private OwnerResponse convertToDto(Owner owner) {
        return modelMapper.map(owner, OwnerResponse.class);
    }
}

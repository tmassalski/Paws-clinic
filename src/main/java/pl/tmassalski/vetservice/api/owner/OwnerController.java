package pl.tmassalski.vetservice.api.owner;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.tmassalski.vetservice.domain.owner.Owner;
import pl.tmassalski.vetservice.domain.owner.OwnerException;
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

    @DeleteMapping(value = "/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long ownerId) {
        if (!ownerFacade.delete(ownerId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner id not found");
        }
    }

    @PutMapping(value = "/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    OwnerResponse update(@PathVariable Long ownerId, @RequestBody @Valid CreateOwnerRequest request) {
        Owner owner = convertToEntity(request);
        try {
            Owner updatedOwner = ownerFacade.update(owner, ownerId);
            return convertToDto(updatedOwner);
        } catch (OwnerException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner id not found", e);
        }
    }

    private Owner convertToEntity(CreateOwnerRequest request) {
        return modelMapper.map(request, Owner.class);
    }

    private OwnerResponse convertToDto(Owner owner) {
        return modelMapper.map(owner, OwnerResponse.class);
    }
}

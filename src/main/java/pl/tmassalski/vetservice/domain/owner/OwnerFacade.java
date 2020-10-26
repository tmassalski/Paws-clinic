package pl.tmassalski.vetservice.domain.owner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tmassalski.vetservice.domain.pet.PetType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerFacade {

    private final OwnerRetrievalClient ownerRetrievalClient;
    private final OwnerCreatorClient ownerCreatorClient;
    private final OwnerUpdaterClient ownerUpdaterClient;

    public Owner createOwner(Owner owner){
      return ownerCreatorClient.create(owner);
    }

    public Owner getOwner(Long id){
        return ownerRetrievalClient.getById(id);
    }

    public List<Owner> getAll() {
        return ownerRetrievalClient.getAll();
    }

    @Transactional
    public boolean delete(Long id) {
        Owner owner = getOwner(id);
        if (owner != null) {
            ownerUpdaterClient.delete(id);
            return true;
        }
        return false;
    }

    @Transactional
    public Owner update(Owner owner, Long id) {
        Owner retrievedOwner = getOwner(id);
        if (retrievedOwner == null) {
            return null;
        }
        retrievedOwner.setFirstName(owner.getFirstName());
        retrievedOwner.setLastName(owner.getLastName());
        retrievedOwner.setAddress(owner.getAddress());
        retrievedOwner.setCity(owner.getCity());
        retrievedOwner.setPhone(owner.getPhone());
        ownerUpdaterClient.save(retrievedOwner);
        return retrievedOwner;
    }
}

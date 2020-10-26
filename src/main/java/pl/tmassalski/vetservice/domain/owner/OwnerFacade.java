package pl.tmassalski.vetservice.domain.owner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerFacade {

    private final OwnerRetrievalClient ownerRetrievalClient;
    private final OwnerCreatorClient ownerCreatorClient;

    public Owner createOwner(Owner owner){
      return ownerCreatorClient.create(owner);
    }

    public Owner getOwner(Long id){
        return ownerRetrievalClient.getById(id);
    }

    public List<Owner> getAll() {
        return ownerRetrievalClient.getAll();
    }
}

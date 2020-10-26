package pl.tmassalski.vetservice.domain.owner;

import java.util.List;

public interface OwnerRetrievalClient {

    Owner getById(Long id);
    List<Owner> getAll();

}

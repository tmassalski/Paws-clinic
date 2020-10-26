package pl.tmassalski.vetservice.domain.owner;

import org.springframework.stereotype.Service;

@Service
public class OwnerCreator {

    Owner create(OwnerCommand ownerCommand) {
        return Owner.generate(ownerCommand);
    }

}

package pl.tmassalski.vetservice.domain.owner;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OwnerCommand {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String phone;
}

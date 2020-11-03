package pl.tmassalski.vetservice.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.tmassalski.vetservice.domain.user.User;
import pl.tmassalski.vetservice.domain.user.UserFacade;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createUser(@RequestBody UserRequest userRequest){
       User createdUser = userFacade.registerNewUser(userRequest);
    }
}

package pl.tmassalski.vetservice.api.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.tmassalski.vetservice.domain.token.Token;
import pl.tmassalski.vetservice.domain.token.TokenFacade;
import pl.tmassalski.vetservice.domain.user.User;
import pl.tmassalski.vetservice.domain.user.UserCommand;
import pl.tmassalski.vetservice.domain.user.UserFacade;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final ModelMapper modelMapper;
    private final UserFacade userFacade;
    private final TokenFacade tokenFacade;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    void registerUser (@RequestBody @Valid UserRequest userRequest) {
        UserCommand command = convertToEntity(userRequest);
        userFacade.registerNewUser(command);
    }

    @GetMapping("/token")
    public ModelAndView confirmRegistration(@RequestParam String value, ModelMap model) {
        Token token = tokenFacade.getByValue(value);
        User user = token.getUser();
        user.setEnabled(true);
        userFacade.updateUser(user);
        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:/login");
    }

    private UserCommand convertToEntity(UserRequest request) {
        return modelMapper.map(request, UserCommand.class);
    }
}

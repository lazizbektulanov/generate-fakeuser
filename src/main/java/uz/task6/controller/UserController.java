package uz.task6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import uz.task6.payload.ParamDto;
import uz.task6.payload.UserDto;
import uz.task6.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ModelAttribute("paramDto")
    public ParamDto registerDto() {
        return new ParamDto();
    }

}

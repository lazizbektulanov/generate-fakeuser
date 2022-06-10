package uz.task6.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.task6.payload.ParamDto;
import uz.task6.payload.UserDto;
import uz.task6.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;

    @GetMapping("/generateNextData")
    public List<UserDto> generateNextData(@RequestParam(name = "dataLength", defaultValue = "0") int dataLength,
                                          @RequestParam(name = "selectedRegion", defaultValue = "de") String selectedRegion,
                                          @RequestParam(name = "errorPerRecord", defaultValue = "0") String errorPerRecord,
                                          @RequestParam(name = "seedNumber", defaultValue = "0") String seedNumber){
        if(dataLength!=0){
            ParamDto paramDto =new ParamDto(selectedRegion,errorPerRecord,seedNumber,dataLength);
            return userService.generateNextData(paramDto);
        }
        else{
            ParamDto paramDto = new ParamDto(selectedRegion,errorPerRecord,seedNumber);
            return userService.generate(paramDto);
        }

    }
}

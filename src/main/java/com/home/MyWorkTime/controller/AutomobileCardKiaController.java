package com.home.MyWorkTime.controller;


import com.home.MyWorkTime.entity.AutomobileCardKiaModel;
import com.home.MyWorkTime.service.AutomobileCardKiaService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/automobile_card_kia")
@AllArgsConstructor
@Log
@CrossOrigin
public class AutomobileCardKiaController {

    private final AutomobileCardKiaService automobileCardKiaService;

    @PostMapping(value = "/automobileCardKia")
    public AutomobileCardKiaModel addNewAutomobileCardKia(@RequestBody AutomobileCardKiaModel automobileCardKiaModel){
        return automobileCardKiaService.addNewAutomobileCardKia(automobileCardKiaModel);
    }

    @GetMapping(value = "/{searchCardKiaBaseInput}")
    public List<AutomobileCardKiaModel> searchCardKiaBase(@PathVariable String searchCardKiaBaseInput){
        return automobileCardKiaService.searchCardKiaBase(searchCardKiaBaseInput);
    }
}

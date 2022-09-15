package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.entity.AutomobileCardKiaModel;
import com.home.MyWorkTime.service.AutomobileCardKiaService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/findByIdCarKia/{id}")
    public Optional<AutomobileCardKiaModel> findById(@PathVariable Long id){
        return automobileCardKiaService.findById(id);
    }

    @PutMapping(value = "/{id}")
    Optional<AutomobileCardKiaModel> updateCarFromBase(@RequestBody AutomobileCardKiaModel newAutomobileCardKiaModel,
                                                       @PathVariable Long id){
        return automobileCardKiaService.findById(id)
                .map(automobileCardKiaModel -> {
                automobileCardKiaModel.setVin(newAutomobileCardKiaModel.getVin());
                automobileCardKiaModel.setAlter_vin(newAutomobileCardKiaModel.getAlter_vin());
                automobileCardKiaModel.setReg_num(newAutomobileCardKiaModel.getReg_num());
                automobileCardKiaModel.setDate_release(newAutomobileCardKiaModel.getDate_release());
                automobileCardKiaModel.setDate_sale(newAutomobileCardKiaModel.getDate_sale());
                automobileCardKiaModel = automobileCardKiaService.addNewAutomobileCardKia(newAutomobileCardKiaModel);
                return automobileCardKiaModel;
                });
    }
}

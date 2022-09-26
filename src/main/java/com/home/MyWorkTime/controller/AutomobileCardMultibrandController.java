package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.entity.AutomobileCardMultibrandModel;
import com.home.MyWorkTime.service.AutomobileCardMultibrandService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/automobile_card_multibrand")
@AllArgsConstructor
@Log
@CrossOrigin
public class AutomobileCardMultibrandController {

    private final AutomobileCardMultibrandService automobileCardMultibrandService;

    @PostMapping(value = "/automobileCardMultibrand")
    public AutomobileCardMultibrandModel addNewAutomobileCardMultibrand(@RequestBody AutomobileCardMultibrandModel automobileCardMultibrandModel){
        return automobileCardMultibrandService.addNewAutomobileCardMultibrand(automobileCardMultibrandModel);
    }

    @GetMapping(value = "/{searchCardBaseInput}")
    public List<AutomobileCardMultibrandModel> searchCardMultibrandBase(@PathVariable String searchCardBaseInput){
        return automobileCardMultibrandService.searchCardMultibrandBase(searchCardBaseInput);
    }

    @GetMapping(value = "/findByIdCarMultibrand/{id}")
    public Optional<AutomobileCardMultibrandModel> findById(@PathVariable Long id){
        return automobileCardMultibrandService.findById(id);
    }

    @PutMapping(value = "/{id}")
    Optional<AutomobileCardMultibrandModel> updateCarFromBase(@RequestBody AutomobileCardMultibrandModel newAutomobileCardMultibrandModel,
                                                         @PathVariable Long id){
        return automobileCardMultibrandService.findById(id)
                .map(automobileCardMultibrandModel -> {
                    automobileCardMultibrandModel.setVin(newAutomobileCardMultibrandModel.getVin());
                    automobileCardMultibrandModel.setReg_num(newAutomobileCardMultibrandModel.getReg_num());
                    automobileCardMultibrandModel.setDate_release(newAutomobileCardMultibrandModel.getDate_release());
                    automobileCardMultibrandModel.setDate_sale(newAutomobileCardMultibrandModel.getDate_sale());
                    automobileCardMultibrandModel = automobileCardMultibrandService.addNewAutomobileCardMultibrand(newAutomobileCardMultibrandModel);
                    return automobileCardMultibrandModel;
                });
    }
}

package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.entity.AutomobileCardCheryModel;
import com.home.MyWorkTime.service.AutomobileCardCheryService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/automobile_card_chery")
@AllArgsConstructor
@Log
@CrossOrigin
public class AutomobileCardCheryController {

    private final AutomobileCardCheryService automobileCardCheryService;

    @PostMapping(value = "/automobileCardChery")
    public AutomobileCardCheryModel addNewAutomobileCardChery(@RequestBody AutomobileCardCheryModel automobileCardCheryModel){
        return automobileCardCheryService.addNewAutomobileCardChery(automobileCardCheryModel);
    }

    @GetMapping(value = "/{searchCardBaseInput}")
    public List<AutomobileCardCheryModel> searchCardCheryBase(@PathVariable String searchCardBaseInput){
        return automobileCardCheryService.searchCardCheryBase(searchCardBaseInput);
    }

    @GetMapping(value = "/findByIdCarChery/{id}")
    public Optional<AutomobileCardCheryModel> findById(@PathVariable Long id){
        return automobileCardCheryService.findById(id);
    }

    @PutMapping(value = "/{id}")
    Optional<AutomobileCardCheryModel> updateCarFromBase(@RequestBody AutomobileCardCheryModel newAutomobileCardCheryModel,
                                                         @PathVariable Long id){
        return automobileCardCheryService.findById(id)
                .map(automobileCardCheryModel -> {
                    automobileCardCheryModel.setVin(newAutomobileCardCheryModel.getVin());
                    automobileCardCheryModel.setReg_num(newAutomobileCardCheryModel.getReg_num());
                    automobileCardCheryModel.setDate_release(newAutomobileCardCheryModel.getDate_release());
                    automobileCardCheryModel.setDate_sale(newAutomobileCardCheryModel.getDate_sale());
                    automobileCardCheryModel = automobileCardCheryService.addNewAutomobileCardChery(newAutomobileCardCheryModel);
                    return automobileCardCheryModel;
                });
    }
}

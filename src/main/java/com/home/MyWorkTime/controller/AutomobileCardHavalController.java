package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.entity.AutomobileCardHavalModel;
import com.home.MyWorkTime.service.AutomobileCardHavalService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/automobile_card_haval")
@AllArgsConstructor
@Log
@CrossOrigin
public class AutomobileCardHavalController {

    private final AutomobileCardHavalService automobileCardHavalService;

    @PostMapping(value = "/automobileCardHaval")
    public AutomobileCardHavalModel addNewAutomobileCardSkoda(@RequestBody AutomobileCardHavalModel automobileCardHavalModel){
        return automobileCardHavalService.addNewAutomobileCardHaval(automobileCardHavalModel);
    }

    @GetMapping(value = "/{searchCardHavalBaseInput}")
    public List<AutomobileCardHavalModel> searchCardHavalBase(@PathVariable String searchCardHavalBaseInput){
        return automobileCardHavalService.searchCardHavalBase(searchCardHavalBaseInput);
    }

    @GetMapping(value = "/findByIdCarHaval/{id}")
    public Optional<AutomobileCardHavalModel> findById(@PathVariable Long id){
        return automobileCardHavalService.findById(id);
    }

    @PutMapping(value = "/{id}")
    Optional<AutomobileCardHavalModel> updateCarFromBase(@RequestBody AutomobileCardHavalModel newAutomobileCardHavalModel,
                                                         @PathVariable Long id){
        return automobileCardHavalService.findById(id)
                .map(automobileCardHavalModel -> {
                    automobileCardHavalModel.setVin(newAutomobileCardHavalModel.getVin());
                    automobileCardHavalModel.setReg_num(newAutomobileCardHavalModel.getReg_num());
                    automobileCardHavalModel.setDate_release(newAutomobileCardHavalModel.getDate_release());
                    automobileCardHavalModel.setDate_sale(newAutomobileCardHavalModel.getDate_sale());
                    automobileCardHavalModel = automobileCardHavalService.addNewAutomobileCardHaval(newAutomobileCardHavalModel);
                    return automobileCardHavalModel;
                });
    }
}

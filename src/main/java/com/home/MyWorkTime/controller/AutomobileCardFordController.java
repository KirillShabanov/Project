package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.entity.AutomobileCardFordModel;
import com.home.MyWorkTime.service.AutomobileCardFordService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/automobile_card_ford")
@AllArgsConstructor
@Log
@CrossOrigin
public class AutomobileCardFordController {

    private final AutomobileCardFordService automobileCardFordService;

    @PostMapping(value = "/automobileCardFord")
    public AutomobileCardFordModel addNewAutomobileCardFord(@RequestBody AutomobileCardFordModel automobileCardFordModel){
        return automobileCardFordService.addNewAutomobileCardFord(automobileCardFordModel);
    }

    @GetMapping(value = "/{searchCardFordBaseInput}")
    public List<AutomobileCardFordModel> searchCardFordBase(@PathVariable String searchCardFordBaseInput){
        return automobileCardFordService.searchCardFordBase(searchCardFordBaseInput);
    }

    @GetMapping(value = "/findByIdCarFord/{id}")
    public Optional<AutomobileCardFordModel> findById(@PathVariable Long id){
        return automobileCardFordService.findById(id);
    }

    @PutMapping(value = "/{id}")
    Optional<AutomobileCardFordModel> updateCarFromBase(@RequestBody AutomobileCardFordModel newAutomobileCardFordModel,
                                                         @PathVariable Long id){
        return automobileCardFordService.findById(id)
                .map(automobileCardFordModel -> {
                    automobileCardFordModel.setVin(newAutomobileCardFordModel.getVin());
                    automobileCardFordModel.setReg_num(newAutomobileCardFordModel.getReg_num());
                    automobileCardFordModel.setDate_release(newAutomobileCardFordModel.getDate_release());
                    automobileCardFordModel.setDate_sale(newAutomobileCardFordModel.getDate_sale());
                    automobileCardFordModel = automobileCardFordService.addNewAutomobileCardFord(newAutomobileCardFordModel);
                    return automobileCardFordModel;
                });
    }
}

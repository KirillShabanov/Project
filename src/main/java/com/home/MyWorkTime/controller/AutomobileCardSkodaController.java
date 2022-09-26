package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.entity.AutomobileCardSkodaModel;
import com.home.MyWorkTime.service.AutomobileCardSkodaService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/automobile_card_skoda")
@AllArgsConstructor
@Log
@CrossOrigin
public class AutomobileCardSkodaController {

    private final AutomobileCardSkodaService automobileCardSkodaService;

    @PostMapping(value = "/automobileCardSkoda")
    public AutomobileCardSkodaModel addNewAutomobileCardSkoda(@RequestBody AutomobileCardSkodaModel automobileCardSkodaModel){
        return automobileCardSkodaService.addNewAutomobileCardSkoda(automobileCardSkodaModel);
    }

    @GetMapping(value = "/{searchCardBaseInput}")
    public List<AutomobileCardSkodaModel> searchCardSkodaBase(@PathVariable String searchCardBaseInput){
        return automobileCardSkodaService.searchCardSkodaBase(searchCardBaseInput);
    }

    @GetMapping(value = "/findByIdCarSkoda/{id}")
    public Optional<AutomobileCardSkodaModel> findById(@PathVariable Long id){
        return automobileCardSkodaService.findById(id);
    }

    @PutMapping(value = "/{id}")
    Optional<AutomobileCardSkodaModel> updateCarFromBase(@RequestBody AutomobileCardSkodaModel newAutomobileCardSkodaModel,
                                                       @PathVariable Long id){
        return automobileCardSkodaService.findById(id)
                .map(automobileCardSkodaModel -> {
                    automobileCardSkodaModel.setVin(newAutomobileCardSkodaModel.getVin());
                    automobileCardSkodaModel.setReg_num(newAutomobileCardSkodaModel.getReg_num());
                    automobileCardSkodaModel.setDate_release(newAutomobileCardSkodaModel.getDate_release());
                    automobileCardSkodaModel.setDate_sale(newAutomobileCardSkodaModel.getDate_sale());
                    automobileCardSkodaModel = automobileCardSkodaService.addNewAutomobileCardSkoda(newAutomobileCardSkodaModel);
                    return automobileCardSkodaModel;
                });
    }
}

package com.home.MyWorkTime.controller;


import com.home.MyWorkTime.entity.CarOwnerSkodaModel;
import com.home.MyWorkTime.service.CarOwnerSkodaService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/car_owner_skoda")
@AllArgsConstructor
@Log
@CrossOrigin
public class CarOwnerSkodaController {

    private final CarOwnerSkodaService carOwnerSkodaService;

    @PostMapping(value = "/saveSkoda")
    public CarOwnerSkodaModel saveOwnerSkoda(@RequestBody CarOwnerSkodaModel carOwnerSkodaModel){
        System.out.println(carOwnerSkodaModel);
        return carOwnerSkodaService.saveOwnerSkoda(carOwnerSkodaModel);
    }

    @GetMapping("/{vinForSearchBaseInput}")
    public List<Map<String, String>> vinForSearchSkodaBaseInputKey(@PathVariable String vinForSearchBaseInput){
        return carOwnerSkodaService.vinForSearchSkodaBaseInputKey(vinForSearchBaseInput);
    }
    @GetMapping("/findById/{id}")
    public Optional<CarOwnerSkodaModel> fundById(@PathVariable Long id){
        return carOwnerSkodaService.findById(id);
    }
}

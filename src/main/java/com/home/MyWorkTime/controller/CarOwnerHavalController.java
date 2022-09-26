package com.home.MyWorkTime.controller;


import com.home.MyWorkTime.entity.CarOwnerHavalModel;
import com.home.MyWorkTime.service.CarOwnerHavalService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/car_owner_haval")
@AllArgsConstructor
@Log
@CrossOrigin
public class CarOwnerHavalController {

    private final CarOwnerHavalService carOwnerHavalService;

    @PostMapping(value = "/saveHaval")
    public CarOwnerHavalModel saveOwner(@RequestBody CarOwnerHavalModel carOwnerHavalModel){
        System.out.println(carOwnerHavalModel);
        return carOwnerHavalService.saveOwner(carOwnerHavalModel);
    }

    @GetMapping("/{vinForSearchBaseInput}")
    public List<Map<String, String>> vinForSearchHavalBaseInputKey(@PathVariable String vinForSearchBaseInput){
        return carOwnerHavalService.vinForSearchHavalBaseInputKey(vinForSearchBaseInput);
    }
    @GetMapping("/findById/{id}")
    public Optional<CarOwnerHavalModel> fundById(@PathVariable Long id){
        return carOwnerHavalService.findById(id);
    }
}

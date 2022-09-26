package com.home.MyWorkTime.controller;


import com.home.MyWorkTime.entity.CarOwnerCheryModel;
import com.home.MyWorkTime.service.CarOwnerCheryService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/car_owner_chery")
@AllArgsConstructor
@Log
@CrossOrigin
public class CarOwnerCheryController {

    private final CarOwnerCheryService carOwnerCheryService;

    @PostMapping(value = "/saveChery")
    public CarOwnerCheryModel saveOwner(@RequestBody CarOwnerCheryModel carOwnerCheryModel){
        System.out.println(carOwnerCheryModel);
        return carOwnerCheryService.saveOwner(carOwnerCheryModel);
    }

    @GetMapping("/{vinForSearchBaseInput}")
    public List<Map<String, String>> vinForSearchCheryBaseInputKey(@PathVariable String vinForSearchBaseInput){
        return carOwnerCheryService.vinForSearchCheryBaseInputKey(vinForSearchBaseInput);
    }
    @GetMapping("/findById/{id}")
    public Optional<CarOwnerCheryModel> fundById(@PathVariable Long id){
        return carOwnerCheryService.findById(id);
    }
}

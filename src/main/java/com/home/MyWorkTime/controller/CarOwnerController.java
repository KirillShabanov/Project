package com.home.MyWorkTime.controller;


import com.home.MyWorkTime.entity.CarOwnerModel;
import com.home.MyWorkTime.service.CarOwnerService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/car_owner")
@AllArgsConstructor
@Log
@CrossOrigin
public class CarOwnerController {

    private final CarOwnerService carOwnerService;

    @PostMapping(value = "/saveKia")
    public CarOwnerModel saveOwner(@RequestBody CarOwnerModel carOwnerModel){
        System.out.println(carOwnerModel);
        return carOwnerService.saveOwner(carOwnerModel);
    }

    @GetMapping("/{vinForSearchBaseInput}")
    public List<Map<String, String>> vinForSearchKiaBaseInputKey(@PathVariable String vinForSearchBaseInput){
        return carOwnerService.vinForSearchKiaBaseInputKey(vinForSearchBaseInput);
    }
    @GetMapping("/findById/{id}")
    public Optional<CarOwnerModel> fundById(@PathVariable Long id){
        return carOwnerService.findById(id);
    }
}

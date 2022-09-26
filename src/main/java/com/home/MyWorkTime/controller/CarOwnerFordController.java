package com.home.MyWorkTime.controller;


import com.home.MyWorkTime.entity.CarOwnerFordModel;
import com.home.MyWorkTime.service.CarOwnerFordService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/car_owner_ford")
@AllArgsConstructor
@Log
@CrossOrigin
public class CarOwnerFordController {

    private final CarOwnerFordService carOwnerFordService;

    @PostMapping(value = "/saveFord")
    public CarOwnerFordModel saveOwner(@RequestBody CarOwnerFordModel carOwnerFordModel){
        System.out.println(carOwnerFordModel);
        return carOwnerFordService.saveOwner(carOwnerFordModel);
    }

    @GetMapping("/{vinForSearchBaseInput}")
    public List<Map<String, String>> vinForSearchFordBaseInputKey(@PathVariable String vinForSearchBaseInput){
        return carOwnerFordService.vinForSearchFordBaseInputKey(vinForSearchBaseInput);
    }
    @GetMapping("/findById/{id}")
    public Optional<CarOwnerFordModel> fundById(@PathVariable Long id){
        return carOwnerFordService.findById(id);
    }
}

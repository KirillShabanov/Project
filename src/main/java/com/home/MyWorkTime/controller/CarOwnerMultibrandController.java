package com.home.MyWorkTime.controller;


import com.home.MyWorkTime.entity.CarOwnerMultibrandModel;
import com.home.MyWorkTime.service.CarOwnerMultibrandService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/car_owner_multibrand")
@AllArgsConstructor
@Log
@CrossOrigin
public class CarOwnerMultibrandController {

    private final CarOwnerMultibrandService carOwnerMultibrandService;

    @PostMapping(value = "/saveMultibrand")
    public CarOwnerMultibrandModel saveOwnerMultibrand(@RequestBody CarOwnerMultibrandModel carOwnerMultibrandModel){
        System.out.println(carOwnerMultibrandModel);
        return carOwnerMultibrandService.saveOwnerMultibrand(carOwnerMultibrandModel);
    }

    @GetMapping("/{vinForSearchBaseInput}")
    public List<Map<String, String>> vinForSearchMultibrandBaseInputKey(@PathVariable String vinForSearchBaseInput){
        return carOwnerMultibrandService.vinForSearchMultibrandBaseInputKey(vinForSearchBaseInput);
    }
    @GetMapping("/findById/{id}")
    public Optional<CarOwnerMultibrandModel> fundById(@PathVariable Long id){
        return carOwnerMultibrandService.findById(id);
    }
}

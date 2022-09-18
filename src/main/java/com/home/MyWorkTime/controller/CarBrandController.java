package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.entity.CarBrandModel;
import com.home.MyWorkTime.service.CarBrandService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car_brand")
@AllArgsConstructor
@Log
@CrossOrigin
public class CarBrandController {

    private final CarBrandService carBrandService;

    @GetMapping("/findAll")
    public List<CarBrandModel> findAll(){
        return carBrandService.findAll();
    }
}

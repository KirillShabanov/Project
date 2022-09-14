package com.home.MyWorkTime.controller;


import com.home.MyWorkTime.service.CarOwnerService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car_owner")
@AllArgsConstructor
@Log
@CrossOrigin
public class CarOwnerController {

    private final CarOwnerService carOwnerService;

    @GetMapping("/{vinForSearchKiaBaseInput}")
    public List<Map<String, String>> vinForSearchKiaBaseInputKey(@PathVariable String vinForSearchKiaBaseInput){
        return carOwnerService.vinForSearchKiaBaseInputKey(vinForSearchKiaBaseInput);
    }
}

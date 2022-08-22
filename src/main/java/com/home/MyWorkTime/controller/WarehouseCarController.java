package com.home.MyWorkTime.controller;


import com.home.MyWorkTime.entity.WarehouseCarModel;
import com.home.MyWorkTime.service.WarehouseCarService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse_car")
@AllArgsConstructor
@Log
@CrossOrigin
public class WarehouseCarController {

    private final WarehouseCarService warehouseCarService;

    @PostMapping(value = "/addNewCar")
    public WarehouseCarModel addNewCar(@RequestBody WarehouseCarModel warehouseCarModel){
       return warehouseCarService.addNewCar(warehouseCarModel);
    }
}

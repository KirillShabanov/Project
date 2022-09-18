package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.entity.OrderOutfitModel;
import com.home.MyWorkTime.service.OrderOutfitService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_outfit")
@AllArgsConstructor
@Log
@CrossOrigin
public class OrderOutfitController {

    private final OrderOutfitService orderOutfitService;

    @GetMapping(value = "/showTable")
    public List<OrderOutfitModel> showTable(){
        return orderOutfitService.showTable();
    }

    @PostMapping(value = "/addOrderOutfit")
    public OrderOutfitModel addOrderOutfit(@RequestBody OrderOutfitModel orderOutfitModel){
        return orderOutfitService.addOrderOutfit(orderOutfitModel);
    }
}

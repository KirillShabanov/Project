package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.entity.CategoryRepairModel;
import com.home.MyWorkTime.service.CategoryRepairService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
@Log
@CrossOrigin
public class CategoryRepairController {

    private final CategoryRepairService categoryRepairService;

    @GetMapping(value = "/categoryRepair")
    public List<CategoryRepairModel> findAllCategory(){
        return categoryRepairService.findAllCategory();
    }
}

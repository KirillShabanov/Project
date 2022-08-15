package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.entity.AutoForTOModel;
import com.home.MyWorkTime.service.AutoForTOService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auto")
@AllArgsConstructor
@Log
@CrossOrigin
public class AutoForTOController {

    private final AutoForTOService autoForTOService;

    @GetMapping(value = "/findAll")
    public List<AutoForTOModel> findAllAuto(){
        log.info("Handling find all auto request");
        return autoForTOService.findAll();
    }
}

package com.home.MyWorkTime.controller;


import com.home.MyWorkTime.entity.RegulForTOModel;
import com.home.MyWorkTime.service.RegulForTOService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regulations")
@AllArgsConstructor
@Log
@CrossOrigin
public class RegulForTOController {

    private final RegulForTOService regulForTOService;

    @GetMapping(value = "/findAll")
    public List<RegulForTOModel> findAllRegul(){
        log.info("Handling find all regulations request");
        return regulForTOService.findAll();
    }
}

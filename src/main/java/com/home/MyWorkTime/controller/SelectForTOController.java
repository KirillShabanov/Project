package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.entity.SelectForTOModel;
import com.home.MyWorkTime.service.SelectForTOService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/to_regulations")
@AllArgsConstructor
@Log
@CrossOrigin
public class SelectForTOController {

    private final SelectForTOService selectForTOService;

    @GetMapping("/{selectTO}&{selectAuto}")
    public List<SelectForTOModel> keyForTO(@PathVariable Long selectTO,
                                           @PathVariable Long selectAuto){
        log.info("Handling find ID TO: " + selectTO);
        log.info("Handling find ID Auto: " + selectAuto);
        return selectForTOService.findTOFromKey(selectTO, selectAuto);
    }

}

package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.AutoForTOModel;
import com.home.MyWorkTime.repository.AutoForTORepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@NoArgsConstructor
public class AutoForTOService {

    private AutoForTORepository autoForTORepository;

    @Autowired
    public AutoForTOService(AutoForTORepository autoForTORepository) {
        this.autoForTORepository = autoForTORepository;
    }

    public List<AutoForTOModel> findAll(){
        return autoForTORepository.findAll();
    }

    public AutoForTOModel findById(Integer id){
        return autoForTORepository.findById(id).get();
    }

}

package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.AutoForTOModel;
import com.home.MyWorkTime.repository.AutoForTORepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class AutoForTOService {

    @Autowired
    private AutoForTORepository autoForTORepository;

    public List<AutoForTOModel> findAll(){
        return autoForTORepository.findAll();
    }

    public AutoForTOModel findById(Integer id){
        return autoForTORepository.findById(id).get();
    }
}

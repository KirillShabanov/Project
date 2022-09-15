package com.home.MyWorkTime.service;



import com.home.MyWorkTime.entity.RegulForTOModel;
import com.home.MyWorkTime.repository.RegulForTORepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class RegulForTOService {

    private RegulForTORepository regulForTORepository;

    @Autowired
    public RegulForTOService(RegulForTORepository regulForTORepository) {
        this.regulForTORepository = regulForTORepository;
    }

    public List<RegulForTOModel> findAll(){
        return regulForTORepository.findAll();
    }

    public RegulForTOModel findById(Integer id){
        return regulForTORepository.findById(id).get();
    }
}

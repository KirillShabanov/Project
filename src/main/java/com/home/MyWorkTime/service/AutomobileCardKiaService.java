package com.home.MyWorkTime.service;


import com.home.MyWorkTime.entity.AutomobileCardKiaModel;
import com.home.MyWorkTime.repository.AutomobileCardKiaRepository;
import com.home.MyWorkTime.repository.AutomobileCardKiaVinRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class AutomobileCardKiaService {

    @Autowired
    private AutomobileCardKiaRepository automobileCardKiaRepository;
    @Autowired
    private AutomobileCardKiaVinRepository automobileCardKiaVinRepository;

    public AutomobileCardKiaModel addNewAutomobileCardKia(AutomobileCardKiaModel automobileCardKiaModel) {
        AutomobileCardKiaModel addNewAutomobileCardKia = automobileCardKiaRepository.save(automobileCardKiaModel);
        return AutomobileCardKiaRepository.saveAutomobileCardKiaModel(addNewAutomobileCardKia);
    }

    public List<AutomobileCardKiaModel> searchCardKiaBase(String searchCardKiaBaseInput) {
        return automobileCardKiaVinRepository.searchCardKiaBase(searchCardKiaBaseInput);
    }
}

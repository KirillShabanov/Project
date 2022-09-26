package com.home.MyWorkTime.service;


import com.home.MyWorkTime.entity.AutomobileCardHavalModel;
import com.home.MyWorkTime.repository.AutomobileCardHavalRepository;
import com.home.MyWorkTime.repository.AutomobileCardHavalVinRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class AutomobileCardHavalService {

    private AutomobileCardHavalRepository automobileCardHavalRepository;
    private AutomobileCardHavalVinRepository automobileCardHavalVinRepository;

    @Autowired
    public AutomobileCardHavalService(AutomobileCardHavalRepository automobileCardHavalRepository, AutomobileCardHavalVinRepository automobileCardHavalVinRepository) {
        this.automobileCardHavalRepository = automobileCardHavalRepository;
        this.automobileCardHavalVinRepository = automobileCardHavalVinRepository;
    }

    public AutomobileCardHavalModel addNewAutomobileCardHaval(AutomobileCardHavalModel automobileCardHavalModel) {
        AutomobileCardHavalModel addNewAutomobileCardHaval = automobileCardHavalRepository.save(automobileCardHavalModel);
        return AutomobileCardHavalRepository.saveAutomobileCardHavalModel(addNewAutomobileCardHaval);
    }

    public List<AutomobileCardHavalModel> searchCardHavalBase(String searchCardBaseInput) {
        return automobileCardHavalVinRepository.searchCardHavalBase(searchCardBaseInput);
    }

    public Optional<AutomobileCardHavalModel> findById(Long id) {
        return automobileCardHavalRepository.findById(id);
    }
}

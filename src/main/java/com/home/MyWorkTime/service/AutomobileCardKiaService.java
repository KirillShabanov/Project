package com.home.MyWorkTime.service;


import com.home.MyWorkTime.entity.AutomobileCardKiaModel;
import com.home.MyWorkTime.repository.AutomobileCardKiaRepository;
import com.home.MyWorkTime.repository.AutomobileCardKiaVinRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@NoArgsConstructor
public class AutomobileCardKiaService {

    private AutomobileCardKiaRepository automobileCardKiaRepository;
    private AutomobileCardKiaVinRepository automobileCardKiaVinRepository;

    @Autowired
    public AutomobileCardKiaService(AutomobileCardKiaRepository automobileCardKiaRepository, AutomobileCardKiaVinRepository automobileCardKiaVinRepository) {
        this.automobileCardKiaRepository = automobileCardKiaRepository;
        this.automobileCardKiaVinRepository = automobileCardKiaVinRepository;
    }

    public AutomobileCardKiaModel addNewAutomobileCardKia(AutomobileCardKiaModel automobileCardKiaModel) {
        AutomobileCardKiaModel addNewAutomobileCardKia = automobileCardKiaRepository.save(automobileCardKiaModel);
        return AutomobileCardKiaRepository.saveAutomobileCardKiaModel(addNewAutomobileCardKia);
    }

    public List<AutomobileCardKiaModel> searchCardKiaBase(String searchCardBaseInput) {
        return automobileCardKiaVinRepository.searchCardKiaBase(searchCardBaseInput);
    }

    public Optional<AutomobileCardKiaModel> findById(Long id) {
        return automobileCardKiaRepository.findById(id);
    }

}

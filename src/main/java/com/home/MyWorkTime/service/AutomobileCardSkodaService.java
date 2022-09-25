package com.home.MyWorkTime.service;


import com.home.MyWorkTime.entity.AutomobileCardSkodaModel;
import com.home.MyWorkTime.repository.AutomobileCardSkodaRepository;
import com.home.MyWorkTime.repository.AutomobileCardSkodaVinRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class AutomobileCardSkodaService {

    private AutomobileCardSkodaRepository automobileCardSkodaRepository;
    private AutomobileCardSkodaVinRepository automobileCardSkodaVinRepository;

    @Autowired
    public AutomobileCardSkodaService(AutomobileCardSkodaRepository automobileCardSkodaRepository, AutomobileCardSkodaVinRepository automobileCardSkodaVinRepository) {
        this.automobileCardSkodaRepository = automobileCardSkodaRepository;
        this.automobileCardSkodaVinRepository = automobileCardSkodaVinRepository;
    }

    public AutomobileCardSkodaModel addNewAutomobileCardSkoda(AutomobileCardSkodaModel automobileCardSkodaModel) {
        AutomobileCardSkodaModel addNewAutomobileCardSkoda = automobileCardSkodaRepository.save(automobileCardSkodaModel);
        return AutomobileCardSkodaRepository.saveAutomobileCardSkodaModel(addNewAutomobileCardSkoda);
    }

    public List<AutomobileCardSkodaModel> searchCardSkodaBase(String searchCardSkodaBaseInput) {
        return automobileCardSkodaVinRepository.searchCardSkodaBase(searchCardSkodaBaseInput);
    }

    public Optional<AutomobileCardSkodaModel> findById(Long id) {
        return automobileCardSkodaRepository.findById(id);
    }
}

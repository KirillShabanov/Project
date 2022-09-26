package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.AutomobileCardCheryModel;
import com.home.MyWorkTime.repository.AutomobileCardCheryRepository;
import com.home.MyWorkTime.repository.AutomobileCardCheryVinRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class AutomobileCardCheryService {

    private AutomobileCardCheryRepository automobileCardCheryRepository;
    private AutomobileCardCheryVinRepository automobileCardCheryVinRepository;

    @Autowired
    public AutomobileCardCheryService(AutomobileCardCheryRepository automobileCardCheryRepository, AutomobileCardCheryVinRepository automobileCardCheryVinRepository) {
        this.automobileCardCheryRepository = automobileCardCheryRepository;
        this.automobileCardCheryVinRepository = automobileCardCheryVinRepository;
    }

    public AutomobileCardCheryModel addNewAutomobileCardChery(AutomobileCardCheryModel automobileCardCheryModel) {
        AutomobileCardCheryModel addNewAutomobileCardChery = automobileCardCheryRepository.save(automobileCardCheryModel);
        return AutomobileCardCheryRepository.saveAutomobileCardCheryModel(addNewAutomobileCardChery);
    }

    public List<AutomobileCardCheryModel> searchCardCheryBase(String searchCardBaseInput) {
        return automobileCardCheryVinRepository.searchCardCheryBase(searchCardBaseInput);
    }

    public Optional<AutomobileCardCheryModel> findById(Long id) {
        return automobileCardCheryRepository.findById(id);
    }
}

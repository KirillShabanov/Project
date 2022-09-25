package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.AutomobileCardMultibrandModel;
import com.home.MyWorkTime.repository.AutomobileCardMultibrandRepository;
import com.home.MyWorkTime.repository.AutomobileCardMultibrandVinRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class AutomobileCardMultibrandService {

    private AutomobileCardMultibrandRepository automobileCardMultibrandRepository;
    private AutomobileCardMultibrandVinRepository automobileCardMultibrandVinRepository;

    @Autowired
    public AutomobileCardMultibrandService(AutomobileCardMultibrandRepository automobileCardMultibrandRepository, AutomobileCardMultibrandVinRepository automobileCardMultibrandVinRepository) {
        this.automobileCardMultibrandRepository = automobileCardMultibrandRepository;
        this.automobileCardMultibrandVinRepository = automobileCardMultibrandVinRepository;
    }

    public AutomobileCardMultibrandModel addNewAutomobileCardMultibrand(AutomobileCardMultibrandModel automobileCardMultibrandModel) {
        AutomobileCardMultibrandModel addNewAutomobileCardMultibrand = automobileCardMultibrandRepository.save(automobileCardMultibrandModel);
        return AutomobileCardMultibrandRepository.saveAutomobileCardMultibrandModel(addNewAutomobileCardMultibrand);
    }

    public List<AutomobileCardMultibrandModel> searchCardMultibrandBase(String searchCardMultibrandBaseInput) {
        return automobileCardMultibrandVinRepository.searchCardMultibrandBase(searchCardMultibrandBaseInput);
    }

    public Optional<AutomobileCardMultibrandModel> findById(Long id) {
        return automobileCardMultibrandRepository.findById(id);
    }
}

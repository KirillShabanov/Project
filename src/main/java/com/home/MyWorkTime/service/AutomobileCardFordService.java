package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.AutomobileCardFordModel;
import com.home.MyWorkTime.repository.AutomobileCardFordRepository;
import com.home.MyWorkTime.repository.AutomobileCardFordVinRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class AutomobileCardFordService {

    private AutomobileCardFordRepository automobileCardFordRepository;
    private AutomobileCardFordVinRepository automobileCardFordVinRepository;

    @Autowired
    public AutomobileCardFordService(AutomobileCardFordRepository automobileCardFordRepository, AutomobileCardFordVinRepository automobileCardFordVinRepository) {
        this.automobileCardFordRepository = automobileCardFordRepository;
        this.automobileCardFordVinRepository = automobileCardFordVinRepository;
    }

    public AutomobileCardFordModel addNewAutomobileCardFord(AutomobileCardFordModel automobileCardFordModel) {
        AutomobileCardFordModel addNewAutomobileCardFord = automobileCardFordRepository.save(automobileCardFordModel);
        return AutomobileCardFordRepository.saveAutomobileCardFordModel(addNewAutomobileCardFord);
    }

    public List<AutomobileCardFordModel> searchCardFordBase(String searchCardFordBaseInput) {
        return automobileCardFordVinRepository.searchCardFordBase(searchCardFordBaseInput);
    }

    public Optional<AutomobileCardFordModel> findById(Long id) {
        return automobileCardFordRepository.findById(id);
    }
}

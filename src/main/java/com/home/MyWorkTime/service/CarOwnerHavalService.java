package com.home.MyWorkTime.service;


import com.home.MyWorkTime.entity.CarOwnerHavalModel;
import com.home.MyWorkTime.repository.CarOwnerHavalRepository;
import com.home.MyWorkTime.repository.CarOwnerVinHavalRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CarOwnerHavalService {

    private CarOwnerVinHavalRepository carOwnerVinHavalRepository;
    private CarOwnerHavalRepository carOwnerHavalRepository;


    @Autowired
    public CarOwnerHavalService(CarOwnerVinHavalRepository carOwnerVinHavalRepository, CarOwnerHavalRepository carOwnerHavalRepository) {
        this.carOwnerVinHavalRepository = carOwnerVinHavalRepository;
        this.carOwnerHavalRepository = carOwnerHavalRepository;
    }

    public List<Map<String, String>> vinForSearchHavalBaseInputKey(String vinForSearchBaseInput){
        return carOwnerVinHavalRepository.vinForSearchHavalBaseInputKey(vinForSearchBaseInput);
    }

    public CarOwnerHavalModel saveOwner(CarOwnerHavalModel carOwnerHavalModel) {
        CarOwnerHavalModel savedOwner = carOwnerHavalRepository.save(carOwnerHavalModel);
        return CarOwnerHavalRepository.saveOwner(savedOwner);
    }

    public Optional<CarOwnerHavalModel> findById(Long id) {
        return carOwnerHavalRepository.findById(id);
    }
}

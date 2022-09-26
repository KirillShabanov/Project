package com.home.MyWorkTime.service;


import com.home.MyWorkTime.entity.CarOwnerCheryModel;
import com.home.MyWorkTime.repository.CarOwnerCheryRepository;
import com.home.MyWorkTime.repository.CarOwnerVinCheryRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CarOwnerCheryService {

    private CarOwnerVinCheryRepository carOwnerVinCheryRepository;
    private CarOwnerCheryRepository carOwnerCheryRepository;


    @Autowired
    public CarOwnerCheryService(CarOwnerVinCheryRepository carOwnerVinCheryRepository, CarOwnerCheryRepository carOwnerCheryRepository) {
        this.carOwnerVinCheryRepository = carOwnerVinCheryRepository;
        this.carOwnerCheryRepository = carOwnerCheryRepository;
    }

    public List<Map<String, String>> vinForSearchCheryBaseInputKey(String vinForSearchBaseInput){
        return carOwnerVinCheryRepository.vinForSearchCheryBaseInputKey(vinForSearchBaseInput);
    }

    public CarOwnerCheryModel saveOwner(CarOwnerCheryModel carOwnerCheryModel) {
        CarOwnerCheryModel savedOwner = carOwnerCheryRepository.save(carOwnerCheryModel);
        return CarOwnerCheryRepository.saveOwner(savedOwner);
    }

    public Optional<CarOwnerCheryModel> findById(Long id) {
        return carOwnerCheryRepository.findById(id);
    }
}

package com.home.MyWorkTime.service;


import com.home.MyWorkTime.entity.CarOwnerFordModel;
import com.home.MyWorkTime.repository.CarOwnerFordRepository;
import com.home.MyWorkTime.repository.CarOwnerVinFordRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CarOwnerFordService {

    private CarOwnerVinFordRepository carOwnerVinFordRepository;
    private CarOwnerFordRepository carOwnerFordRepository;


    @Autowired
    public CarOwnerFordService(CarOwnerVinFordRepository carOwnerVinFordRepository, CarOwnerFordRepository carOwnerFordRepository) {
        this.carOwnerVinFordRepository = carOwnerVinFordRepository;
        this.carOwnerFordRepository = carOwnerFordRepository;
    }

    public List<Map<String, String>> vinForSearchFordBaseInputKey(String vinForSearchBaseInput){
        return carOwnerVinFordRepository.vinForSearchFordBaseInputKey(vinForSearchBaseInput);
    }

    public CarOwnerFordModel saveOwner(CarOwnerFordModel carOwnerFordModel) {
        CarOwnerFordModel savedOwner = carOwnerFordRepository.save(carOwnerFordModel);
        return CarOwnerFordRepository.saveOwner(savedOwner);
    }

    public Optional<CarOwnerFordModel> findById(Long id) {
        return carOwnerFordRepository.findById(id);
    }
}

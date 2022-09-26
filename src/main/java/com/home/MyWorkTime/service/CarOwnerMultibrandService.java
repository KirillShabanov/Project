package com.home.MyWorkTime.service;


import com.home.MyWorkTime.entity.CarOwnerMultibrandModel;
import com.home.MyWorkTime.repository.CarOwnerMultibrandRepository;
import com.home.MyWorkTime.repository.CarOwnerVinMultibrandRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CarOwnerMultibrandService {

    private CarOwnerVinMultibrandRepository carOwnerVinMultibrandRepository;
    private CarOwnerMultibrandRepository carOwnerMultibrandRepository;


    @Autowired
    public CarOwnerMultibrandService(CarOwnerVinMultibrandRepository carOwnerVinMultibrandRepository, CarOwnerMultibrandRepository carOwnerMultibrandRepository) {
        this.carOwnerVinMultibrandRepository = carOwnerVinMultibrandRepository;
        this.carOwnerMultibrandRepository = carOwnerMultibrandRepository;
    }

    public List<Map<String, String>> vinForSearchMultibrandBaseInputKey(String vinForSearchBaseInput){
        return carOwnerVinMultibrandRepository.vinForSearchMultibrandBaseInputKey(vinForSearchBaseInput);
    }

    public CarOwnerMultibrandModel saveOwnerMultibrand(CarOwnerMultibrandModel carOwnerMultibrandModel) {
        CarOwnerMultibrandModel savedOwner = carOwnerMultibrandRepository.save(carOwnerMultibrandModel);
        return CarOwnerMultibrandRepository.saveOwnerMultibrand(savedOwner);
    }

    public Optional<CarOwnerMultibrandModel> findById(Long id) {
        return carOwnerMultibrandRepository.findById(id);
    }
}

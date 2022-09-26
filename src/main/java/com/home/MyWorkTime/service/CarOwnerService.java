package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.CarOwnerModel;
import com.home.MyWorkTime.repository.CarOwnerRepository;
import com.home.MyWorkTime.repository.CarOwnerVinRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CarOwnerService {

    private CarOwnerVinRepository carOwnerVinRepository;
    private CarOwnerRepository carOwnerRepository;


    @Autowired
    public CarOwnerService(CarOwnerVinRepository carOwnerVinRepository, CarOwnerRepository carOwnerRepository) {
        this.carOwnerVinRepository = carOwnerVinRepository;
        this.carOwnerRepository = carOwnerRepository;
    }

    public List<Map<String, String>> vinForSearchKiaBaseInputKey(String vinForSearchBaseInput){
        return carOwnerVinRepository.vinForSearchKiaBaseInputKey(vinForSearchBaseInput);
    }

    public CarOwnerModel saveOwner(CarOwnerModel carOwnerModel) {
        CarOwnerModel savedOwner = carOwnerRepository.save(carOwnerModel);
        return CarOwnerRepository.saveOwner(savedOwner);
    }

    public Optional<CarOwnerModel> findById(Long id) {
        return carOwnerRepository.findById(id);
    }
}

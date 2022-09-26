package com.home.MyWorkTime.service;


import com.home.MyWorkTime.entity.CarOwnerSkodaModel;
import com.home.MyWorkTime.repository.CarOwnerSkodaRepository;
import com.home.MyWorkTime.repository.CarOwnerVinSkodaRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CarOwnerSkodaService {

    private CarOwnerVinSkodaRepository carOwnerVinSkodaRepository;
    private CarOwnerSkodaRepository carOwnerSkodaRepository;


    @Autowired
    public CarOwnerSkodaService(CarOwnerVinSkodaRepository carOwnerVinSkodaRepository, CarOwnerSkodaRepository carOwnerSkodaRepository) {
        this.carOwnerVinSkodaRepository = carOwnerVinSkodaRepository;
        this.carOwnerSkodaRepository = carOwnerSkodaRepository;
    }

    public List<Map<String, String>> vinForSearchSkodaBaseInputKey(String vinForSearchBaseInput){
        return carOwnerVinSkodaRepository.vinForSearchSkodaBaseInputKey(vinForSearchBaseInput);
    }

    public CarOwnerSkodaModel saveOwnerSkoda(CarOwnerSkodaModel carOwnerSkodaModel) {
        CarOwnerSkodaModel savedOwner = carOwnerSkodaRepository.save(carOwnerSkodaModel);
        return CarOwnerSkodaRepository.saveOwnerSkoda(savedOwner);
    }

    public Optional<CarOwnerSkodaModel> findById(Long id) {
        return carOwnerSkodaRepository.findById(id);
    }
}

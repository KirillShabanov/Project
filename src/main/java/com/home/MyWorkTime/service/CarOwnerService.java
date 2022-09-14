package com.home.MyWorkTime.service;

import com.home.MyWorkTime.repository.CarOwnerVinRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class CarOwnerService {

    @Autowired
    private CarOwnerVinRepository carOwnerVinRepository;

    public List<Map<String, String>> vinForSearchKiaBaseInputKey(String vinForSearchKiaBaseInput){
        return carOwnerVinRepository.vinForSearchKiaBaseInputKey(vinForSearchKiaBaseInput);
    }
}

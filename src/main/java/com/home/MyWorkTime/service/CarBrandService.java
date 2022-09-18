package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.CarBrandModel;
import com.home.MyWorkTime.repository.CarBrandRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class CarBrandService {

    @Autowired
    private CarBrandRepository carBrandRepository;

    public List<CarBrandModel> findAll() {
        return carBrandRepository.findAll();
    }
}

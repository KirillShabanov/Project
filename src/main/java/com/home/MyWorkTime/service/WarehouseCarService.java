package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.WarehouseCarModel;
import com.home.MyWorkTime.repository.WarehouseCarRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class WarehouseCarService {
    
    @Autowired
    private WarehouseCarRepository warehouseCarRepository;

    public WarehouseCarModel addNewCar(WarehouseCarModel warehouseCarModel) {
        WarehouseCarModel addNewCar = warehouseCarRepository.save(warehouseCarModel);
        return WarehouseCarRepository.saveWarehouseCarModel(addNewCar);
    }
}

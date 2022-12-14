package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.WarehouseCarModel;
import com.home.MyWorkTime.repository.WarehouseCarRepository;
import com.home.MyWorkTime.repository.WarehouseCarVinRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class WarehouseCarService {
    
    private WarehouseCarRepository warehouseCarRepository;
    private WarehouseCarVinRepository warehouseCarVinRepository;

    @Autowired
    public WarehouseCarService(WarehouseCarRepository warehouseCarRepository, WarehouseCarVinRepository warehouseCarVinRepository) {
        this.warehouseCarRepository = warehouseCarRepository;
        this.warehouseCarVinRepository = warehouseCarVinRepository;
    }

    public WarehouseCarModel addNewCar(WarehouseCarModel warehouseCarModel) {
        WarehouseCarModel addNewCar = warehouseCarRepository.save(warehouseCarModel);
        return WarehouseCarRepository.saveWarehouseCarModel(addNewCar);
    }

    public List<WarehouseCarModel> findAllNotSale() {
        return warehouseCarRepository.findAllNotSale();
    }

    public List<WarehouseCarModel> findAllNotSaleNotNull(String findAllNotSaleNotNull) {
        return warehouseCarVinRepository.findAllNotSaleNotNull(findAllNotSaleNotNull);
    }

}

package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.WarehouseCarModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WarehouseCarRepository extends JpaRepository<WarehouseCarModel, Long> {

    static WarehouseCarModel saveWarehouseCarModel(WarehouseCarModel warehouseCarModel){
        return warehouseCarModel;
    }
}

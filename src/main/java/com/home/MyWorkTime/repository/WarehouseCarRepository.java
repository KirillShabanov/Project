package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.WarehouseCarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface WarehouseCarRepository extends JpaRepository<WarehouseCarModel, Long> {

    static WarehouseCarModel saveWarehouseCarModel(WarehouseCarModel warehouseCarModel){
        return warehouseCarModel;
    }

    @Transactional
    @Query(value = "SELECT * FROM warehouse_car WHERE date_sale IS null", nativeQuery = true)
    List<WarehouseCarModel> findAllNotSale();

}

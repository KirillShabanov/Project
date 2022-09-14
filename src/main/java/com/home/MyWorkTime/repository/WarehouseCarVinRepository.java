package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.WarehouseCarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;



public interface WarehouseCarVinRepository extends JpaRepository<WarehouseCarModel, String> {

    @Transactional
    @Query(value = "SELECT * FROM warehouse_car WHERE date_sale IS null AND vin LIKE %:findAllNotSaleNotNull% ", nativeQuery = true)
    List<WarehouseCarModel> findAllNotSaleNotNull(String findAllNotSaleNotNull);


}

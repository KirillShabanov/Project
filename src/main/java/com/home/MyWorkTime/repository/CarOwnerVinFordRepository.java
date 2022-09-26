package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CarOwnerCheryModel;
import com.home.MyWorkTime.entity.CarOwnerFordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface CarOwnerVinFordRepository extends JpaRepository<CarOwnerFordModel, String> {

    @Transactional
    @Query(value = "SELECT car_owner_ford.id, vin, reg_num, client_full_name, phone FROM car_owner_ford " +
            "LEFT JOIN clients_card ON car_owner_ford.FK_owner = clients_card.id " +
            "LEFT JOIN automobile_card_ford ON car_owner_ford.FK_vin = automobile_card_ford.id " +
            "WHERE vin LIKE %:vinForSearchBaseInput% ", nativeQuery = true)
    List<Map<String,String>> vinForSearchFordBaseInputKey(@Param("vinForSearchBaseInput") String vinForSearchBaseInput);

}

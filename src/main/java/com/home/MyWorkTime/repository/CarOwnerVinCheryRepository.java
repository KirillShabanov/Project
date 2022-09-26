package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CarOwnerCheryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface CarOwnerVinCheryRepository extends JpaRepository<CarOwnerCheryModel, String> {

    @Transactional
    @Query(value = "SELECT car_owner_chery.id, vin, reg_num, client_full_name, phone FROM car_owner_chery " +
            "LEFT JOIN clients_card ON car_owner_chery.FK_owner = clients_card.id " +
            "LEFT JOIN automobile_card_chery ON car_owner_chery.FK_vin = automobile_card_chery.id " +
            "WHERE vin LIKE %:vinForSearchBaseInput% ", nativeQuery = true)
    List<Map<String,String>> vinForSearchCheryBaseInputKey(@Param("vinForSearchBaseInput") String vinForSearchBaseInput);

}

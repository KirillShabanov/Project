package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CarOwnerMultibrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface CarOwnerVinMultibrandRepository extends JpaRepository<CarOwnerMultibrandModel, String> {

    @Transactional
    @Query(value = "SELECT car_owner_multibrand.id, vin, reg_num, client_full_name, phone FROM car_owner_multibrand " +
            "LEFT JOIN clients_card ON car_owner_multibrand.FK_owner = clients_card.id " +
            "LEFT JOIN automobile_card_multibrand ON car_owner_multibrand.FK_vin = automobile_card_multibrand.id " +
            "WHERE vin LIKE %:vinForSearchBaseInput% ", nativeQuery = true)
    List<Map<String,String>> vinForSearchMultibrandBaseInputKey(@Param("vinForSearchBaseInput") String vinForSearchBaseInput);

}

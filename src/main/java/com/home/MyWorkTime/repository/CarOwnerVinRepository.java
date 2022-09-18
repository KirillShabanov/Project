package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CarOwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface CarOwnerVinRepository extends JpaRepository<CarOwnerModel, String> {

    @Transactional
    @Query(value = "SELECT car_owner.id, vin, reg_num, client_full_name, phone FROM car_owner " +
            "LEFT JOIN clients_card ON car_owner.FK_owner = clients_card.id " +
            "LEFT JOIN automobile_card_kia ON car_owner.FK_vin = automobile_card_kia.id " +
            "WHERE vin LIKE %:vinForSearchKiaBaseInput% ", nativeQuery = true)
    List<Map<String,String>> vinForSearchKiaBaseInputKey(@Param("vinForSearchKiaBaseInput") String vinForSearchKiaBaseInput);

}

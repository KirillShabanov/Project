package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CarOwnerHavalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface CarOwnerVinHavalRepository extends JpaRepository<CarOwnerHavalModel, String> {

    @Transactional
    @Query(value = "SELECT car_owner_haval.id, vin, reg_num, client_full_name, phone FROM car_owner_haval " +
            "LEFT JOIN clients_card ON car_owner_haval.FK_owner = clients_card.id " +
            "LEFT JOIN automobile_card_haval ON car_owner_haval.FK_vin = automobile_card_haval.id " +
            "WHERE vin LIKE %:vinForSearchBaseInput% ", nativeQuery = true)
    List<Map<String,String>> vinForSearchHavalBaseInputKey(@Param("vinForSearchBaseInput") String vinForSearchBaseInput);

}

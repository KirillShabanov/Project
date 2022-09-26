package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.CarOwnerCheryModel;
import com.home.MyWorkTime.entity.CarOwnerSkodaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface CarOwnerVinSkodaRepository extends JpaRepository<CarOwnerSkodaModel, String> {

    @Transactional
    @Query(value = "SELECT car_owner_skoda.id, vin, reg_num, client_full_name, phone FROM car_owner_skoda " +
            "LEFT JOIN clients_card ON car_owner_skoda.FK_owner = clients_card.id " +
            "LEFT JOIN automobile_card_skoda ON car_owner_skoda.FK_vin = automobile_card_skoda.id " +
            "WHERE vin LIKE %:vinForSearchBaseInput% ", nativeQuery = true)
    List<Map<String,String>> vinForSearchSkodaBaseInputKey(@Param("vinForSearchBaseInput") String vinForSearchBaseInput);

}

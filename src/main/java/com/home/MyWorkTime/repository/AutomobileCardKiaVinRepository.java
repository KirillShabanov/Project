package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.AutomobileCardKiaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface AutomobileCardKiaVinRepository extends JpaRepository<AutomobileCardKiaModel, String> {

    @Transactional
    @Query(value = "SELECT * FROM automobile_card_kia WHERE vin LIKE %:searchCardKiaBaseInput% ", nativeQuery = true)
    List<AutomobileCardKiaModel> searchCardKiaBase(String searchCardKiaBaseInput);

}

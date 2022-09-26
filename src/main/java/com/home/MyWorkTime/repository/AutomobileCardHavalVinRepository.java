package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.AutomobileCardHavalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AutomobileCardHavalVinRepository extends JpaRepository<AutomobileCardHavalModel, String> {

    @Transactional
    @Query(value = "SELECT * FROM automobile_card_haval WHERE vin LIKE %:searchCardBaseInput% ", nativeQuery = true)
    List<AutomobileCardHavalModel> searchCardHavalBase(String searchCardBaseInput);
}

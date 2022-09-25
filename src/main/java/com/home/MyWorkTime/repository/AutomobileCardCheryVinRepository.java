package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.AutomobileCardCheryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AutomobileCardCheryVinRepository extends JpaRepository<AutomobileCardCheryModel, String> {

    @Transactional
    @Query(value = "SELECT * FROM automobile_card_chery WHERE vin LIKE %:searchCardCheryBaseInput% ", nativeQuery = true)
    List<AutomobileCardCheryModel> searchCardCheryBase(String searchCardCheryBaseInput);
}

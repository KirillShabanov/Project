package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.AutomobileCardHavalModel;
import com.home.MyWorkTime.entity.AutomobileCardMultibrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AutomobileCardMultibrandVinRepository extends JpaRepository<AutomobileCardMultibrandModel, String> {

    @Transactional
    @Query(value = "SELECT * FROM automobile_card_multibrandhaval WHERE vin LIKE %:searchCardMultibrandBaseInput% ", nativeQuery = true)
    List<AutomobileCardMultibrandModel> searchCardMultibrandBase(String searchCardMultibrandBaseInput);
}

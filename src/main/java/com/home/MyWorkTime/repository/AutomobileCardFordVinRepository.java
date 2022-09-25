package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.AutomobileCardFordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AutomobileCardFordVinRepository extends JpaRepository<AutomobileCardFordModel, String> {

    @Transactional
    @Query(value = "SELECT * FROM automobile_card_ford WHERE vin LIKE %:searchCardFordBaseInput% ", nativeQuery = true)
    List<AutomobileCardFordModel> searchCardFordBase(String searchCardFordBaseInput);
}

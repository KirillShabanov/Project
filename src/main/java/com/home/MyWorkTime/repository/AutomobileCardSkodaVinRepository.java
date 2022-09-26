package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.AutomobileCardSkodaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AutomobileCardSkodaVinRepository extends JpaRepository<AutomobileCardSkodaModel, String> {

    @Transactional
    @Query(value = "SELECT * FROM automobile_card_skoda WHERE vin LIKE %:searchCardBaseInput% ", nativeQuery = true)
    List<AutomobileCardSkodaModel> searchCardSkodaBase(String searchCardBaseInput);
}

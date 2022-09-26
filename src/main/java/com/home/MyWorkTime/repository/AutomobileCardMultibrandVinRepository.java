package com.home.MyWorkTime.repository;


import com.home.MyWorkTime.entity.AutomobileCardMultibrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AutomobileCardMultibrandVinRepository extends JpaRepository<AutomobileCardMultibrandModel, String> {

    @Transactional
    @Query(value = "SELECT * FROM automobile_card_multibrand WHERE vin LIKE %:searchCardBaseInput% ", nativeQuery = true)
    List<AutomobileCardMultibrandModel> searchCardMultibrandBase(String searchCardBaseInput);
}

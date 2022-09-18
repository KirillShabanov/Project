package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.OrderOutfitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderOutfitRepository extends JpaRepository<OrderOutfitModel, Long> {

    @Transactional
    @Query(value = "SELECT * FROM order_outfit WHERE create_date_position - date_order <= 2",
    nativeQuery = true)
    List<OrderOutfitModel> showTable();
}

package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.OrderOutfitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface OrderOutfitRepository extends JpaRepository<OrderOutfitModel, Long> {

    @Transactional
    @Query(value = "SELECT * FROM order_outfit WHERE create_date_position - date_order <= 2 ",
            nativeQuery = true)
    List<OrderOutfitModel> showTable();

    @Modifying
    @Transactional
    @Query(value = "UPDATE order_outfit SET date_first_call = :interDateFirstCall, " +
            "status_1 = 'call' " +
            "WHERE num_order = :numOrder ",
            nativeQuery = true)
    void updateOrderFirstCall(@Param("interDateFirstCall") Date interDateFirstCall,
                              @Param("numOrder") int numOrder);

    @Modifying
    @Transactional
    @Query(value = "UPDATE order_outfit SET administrator_name = :interSet, " +
            "nps = :interNps, " +
            "date_nps_call = :interDateNpsCall," +
            "status_2 = 'call' " +
            "WHERE num_order = :numOrder ",
            nativeQuery = true)
    void updateOrderNpsCall(@Param("interSet") String interSet,
                            @Param("interNps") int interNps,
                            @Param("interDateNpsCall") Date interDateNpsCall,
                            @Param("numOrder") int numOrder);

}

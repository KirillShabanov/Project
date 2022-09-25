package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.MultibrandMailOrderModel;
import com.home.MyWorkTime.entity.SkodaMailOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MultibrandMailOrderRepository extends JpaRepository<MultibrandMailOrderModel, Long> {

    @Query(value = "SELECT * FROM order_outfit " +
            "WHERE brand = 'Haval' " +
            "OR brand = 'Chery' " +
            "OR brand = 'Ford' " +
            "OR brand = 'Multibrand' " +
            "AND CURRENT_DATE - date_order = 1 " +
            "AND status_1 = 'not call' " , nativeQuery = true)
    ArrayList<MultibrandMailOrderModel> getFirstCall();

    @Query(value = "SELECT * FROM order_outfit " +
            "WHERE brand = 'Haval' " +
            "OR brand = 'Chery' " +
            "OR brand = 'Ford' " +
            "OR brand = 'Multibrand' " +
            "AND CURRENT_DATE - date_order = 2 " +
            "AND status_2 = 'not call' ", nativeQuery = true)
    List<MultibrandMailOrderModel> getNPSCall();
}

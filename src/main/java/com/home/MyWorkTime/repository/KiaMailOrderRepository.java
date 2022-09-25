package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.KiaMailOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface KiaMailOrderRepository extends JpaRepository<KiaMailOrderModel, Long> {

    @Query(value = "SELECT * FROM order_outfit " +
            "WHERE brand = 'KIA' " +
            "AND CURRENT_DATE - date_order = 0 " +
            "AND status_1 = 'not call' " , nativeQuery = true)
    ArrayList<KiaMailOrderModel> getFirstCall();

    @Query(value = "SELECT * FROM order_outfit " +
            "WHERE brand = 'KIA' " +
            "AND CURRENT_DATE - date_order = 2 " +
            "AND status_2 = 'not call' ", nativeQuery = true)
    List<KiaMailOrderModel> getNPSCall();
}

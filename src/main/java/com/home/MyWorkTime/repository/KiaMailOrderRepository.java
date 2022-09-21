package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.KiaMailOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface KiaMailOrderRepository extends JpaRepository<KiaMailOrderModel, Long> {

    @Query(value = "SELECT * FROM order_outfit " +
            "WHERE CURRENT_DATE - date_order = 1 AND status_1 = 'not sent' " , nativeQuery = true)
    ArrayList<KiaMailOrderModel> getFirstCall();

    @Query(value = "SELECT * FROM order_outfit " +
            "WHERE CURRENT_DATE - date_order = 9 AND status_2 = 'not sent' ", nativeQuery = true)
    List<KiaMailOrderModel> getNPSCall();
}

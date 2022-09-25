package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.ReportCallForVASModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReportCallForVASRepository extends JpaRepository<ReportCallForVASModel, Long> {

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE brand = :brand " +
            "AND master_receiver_name = :name " +
            "AND nps > 8  " +
            "AND MONTH(date_order) = MONTH(NOW()) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getPromoterForMonth(@Param("brand") String brand,
                              @Param("name") String name);

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE brand = :brand " +
            "AND master_receiver_name = :name " +
            "AND nps < 7  " +
            "AND MONTH(date_order) = MONTH(NOW()) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getCriticForMonth(@Param("brand") String brand,
                           @Param("name") String name);


    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE brand = :brand " +
            "AND master_receiver_name = :name " +
            "AND nps > 8  " +
            "AND WEEK(date_order, 1) = WEEK(NOW(), 1) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getPromoterForWeek(@Param("brand") String brand,
                            @Param("name") String name);

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE brand = :brand " +
            "AND master_receiver_name = :name " +
            "AND nps < 7 " +
            "AND WEEK(date_order, 1) = WEEK(NOW(), 1) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getCriticForWeek(@Param("brand") String brand,
                            @Param("name") String name);

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE brand = :brand " +
            "AND nps > 8  " +
            "AND MONTH(date_order) = MONTH(NOW()) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getPromoterForMonthDepartment(@Param("brand") String brand);

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE brand = :brand " +
            "AND nps < 7  " +
            "AND MONTH(date_order) = MONTH(NOW()) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getCriticMonthDepartment(@Param("brand") String brand);


    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE brand != 'KIA' " +
            "AND master_receiver_name = :name " +
            "AND nps > 8  " +
            "AND MONTH(date_order) = MONTH(NOW()) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getPromoterForMonthMulti(@Param("name") String name);

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE brand != 'KIA' " +
            "AND master_receiver_name = :name " +
            "AND nps < 7  " +
            "AND MONTH(date_order) = MONTH(NOW()) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getCriticForMonthMulti(@Param("name") String name);


    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE brand != 'KIA' " +
            "AND master_receiver_name = :name " +
            "AND nps > 8  " +
            "AND WEEK(date_order, 1) = WEEK(NOW(), 1) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getPromoterForWeekMulti(@Param("name") String name);

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE brand != 'KIA' " +
            "AND master_receiver_name = :name " +
            "AND nps < 7 " +
            "AND WEEK(date_order, 1) = WEEK(NOW(), 1) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getCriticForWeekMulti(@Param("name") String name);

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE brand != 'KIA' " +
            "AND nps > 8  " +
            "AND MONTH(date_order) = MONTH(NOW()) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getPromoterForMonthDepartmentMulti();

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE brand != 'KIA' " +
            "AND nps < 7  " +
            "AND MONTH(date_order) = MONTH(NOW()) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getCriticMonthDepartmentMulti();

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE nps > 8  " +
            "AND MONTH(date_order) = MONTH(NOW()) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getPromoterForMonthAll();

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE nps < 7  " +
            "AND MONTH(date_order) = MONTH(NOW()) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getCriticForMonthAll();




    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE master_receiver_name = :name " +
            "AND nps > 8  " +
            "AND MONTH(date_order) = MONTH(NOW()) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getPromoterForMonthGarantia(@Param("name") String name);

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE master_receiver_name = :name " +
            "AND nps < 7  " +
            "AND MONTH(date_order) = MONTH(NOW()) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getCriticForMonthGarantia(@Param("name") String name);


    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE master_receiver_name = :name " +
            "AND nps > 8  " +
            "AND WEEK(date_order, 1) = WEEK(NOW(), 1) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getPromoterForWeekGarantia(@Param("name") String name);

    @Transactional
    @Query(value = "SELECT COUNT(id) FROM order_outfit " +
            "WHERE master_receiver_name = :name " +
            "AND nps < 7 " +
            "AND WEEK(date_order, 1) = WEEK(NOW(), 1) " +
            "AND YEAR(date_order) = YEAR(NOW()) ", nativeQuery = true)
    int getCriticForWeekGarantia(@Param("name") String name);
}

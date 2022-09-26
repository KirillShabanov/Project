package com.home.MyWorkTime.repository;

import com.home.MyWorkTime.entity.ReportAtlantKiaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface ReportAtlantKiaVinRepository extends JpaRepository<ReportAtlantKiaModel, String> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO full_nps (brand, num_order, vin, call_date, administrator_name, bq010, bq020, bq030, bq030_remark, bq040, bq050, bq050_remark, bq060, bq070, bq080, bq080_remark, sq010, sq020, sq030, sq040, sq050, sq060, sq070, sq080, sq090, sq110, sq120, sq130, sq140, dq010, dq020, dq030, dq040) " +
            "VALUES (:brand, :num_order, :vin, :call_date, :administrator_name, :bq010, :bq020, :bq030, :bq030_remark, :bq040, :bq050, :bq050_remark, :bq060, :bq070, :bq080, :bq080_remark, :sq010, :sq020, :sq030, :sq040, :sq050, :sq060, :sq070, :sq080, :sq090, :sq110, :sq120, :sq130, :sq140, :dq010, :dq020, :dq030, :dq040) ",
            nativeQuery = true)
    void createReportAtlantKia(@Param("brand") String brand,
                            @Param("num_order") int num_order,
                            @Param("vin") String vin,
                            @Param("call_date") Date call_date,
                            @Param("administrator_name") String administrator_name,
                            @Param("bq010") int bq010,
                            @Param("bq020") int bq020,
                            @Param("bq030") int bq030,
                            @Param("bq030_remark") String bq030_remark,
                            @Param("bq040") int bq040,
                            @Param("bq050") int bq050,
                            @Param("bq050_remark") String bq050_remark,
                            @Param("bq060") int bq060,
                            @Param("bq070") int bq070,
                            @Param("bq080") int bq080,
                            @Param("bq080_remark") String bq080_remark,
                            @Param("sq010") int sq010,
                            @Param("sq020") int sq020,
                            @Param("sq030") int sq030,
                            @Param("sq040") int sq040,
                            @Param("sq050") int sq050,
                            @Param("sq060") int sq060,
                            @Param("sq070") int sq070,
                            @Param("sq080") int sq080,
                            @Param("sq090") int sq090,
                            @Param("sq110") int sq110,
                            @Param("sq120") int sq120,
                            @Param("sq130") int sq130,
                            @Param("sq140") int sq140,
                            @Param("dq010") int dq010,
                            @Param("dq020") int dq020,
                            @Param("dq030") int dq030,
                            @Param("dq040") int dq040);
}

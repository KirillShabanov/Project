package com.home.MyWorkTime.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "full_nps")
@NoArgsConstructor
@AllArgsConstructor
public class ReportAtlantKiaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String brand;
    @Column
    private Long num_order;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate call_date;
    @Column
    private String administrator_name;
    @Column
    private int bq010;
    @Column
    private int bq020;
    @Column
    private int bq030;
    @Column
    private String bq030_remark;
    @Column
    private int bq040;
    @Column
    private int bq050;
    @Column
    private String bq050_remark;
    @Column
    private int bq060;
    @Column
    private int bq070;
    @Column
    private int bq080;
    @Column
    private String bq080_remark;
    @Column
    private int sq010;
    @Column
    private int sq020;
    @Column
    private int sq030;
    @Column
    private int sq040;
    @Column
    private int sq050;
    @Column
    private int sq060;
    @Column
    private int sq070;
    @Column
    private int sq080;
    @Column
    private int sq090;
    @Column
    private int sq110;
    @Column
    private int sq120;
    @Column
    private int sq130;
    @Column
    private int sq140;
    @Column
    private int dq010;
    @Column
    private int dq020;
    @Column
    private int dq030;
    @Column
    private int dq040;
}

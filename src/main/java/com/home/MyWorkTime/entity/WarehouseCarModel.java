package com.home.MyWorkTime.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Data
@Entity
@Table(name = "warehouse_car")
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseCarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String vin;
    @Column
    private String alter_vin;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_arrival;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_release;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_sale;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate create_date_position;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate insp_deliv;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pdi;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate insp_proof;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate insp_30day;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate insp_60day;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate insp_90day;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate insp_120day;

    public String getInsp_deliv() {
        if (insp_deliv == null){
            return " ";
        } else {
            return insp_deliv.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

    public String getPdi() {
        if (pdi == null){
            return " ";
        } else {
            return pdi.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

    public String getInsp_proof() {
        if (insp_proof == null){
            return " ";
        } else {
            return insp_proof.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

    public String getInsp_30day() {
        if (insp_30day == null){
            return " ";
        } else {
            return insp_30day.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

    public String getInsp_60day() {
        if (insp_60day == null){
            return " ";
        } else {
            return insp_60day.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

    public String getInsp_90day() {
        if (insp_90day == null){
            return " ";
        } else {
            return insp_90day.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

    public String getInsp_120day() {
        if (insp_120day == null){
            return " ";
        } else {
            return insp_120day.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

}

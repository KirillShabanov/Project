package com.home.MyWorkTime.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="order_outfit")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderOutfitModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long num_order;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_order;
    @Column
    private String category;
    @Column
    private String vin;
    @Column
    private Long mileage;
    @Column
    private String reg_num;
    @Column
    private String client_name;
    @Column
    private String master_receiver_name;
    @Column
    private String administrator_name;
    @Column
    private Double nps_master_receiver;
    @Column
    private Double nps_service;
    @Column
    private Double nps_mechanic;
    @Column
    private Double nps;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_first_call;
    @Column
    private Long id_first_call;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_nps_call;
    @Column
    private Long id_nps_call;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate create_date_position;

    public String getDate_order() {
        if (date_order == null){
            return " ";
        } else {
            return date_order.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }
    public String getDate_first_call() {
        if (date_first_call == null){
            return " ";
        } else {
            return date_first_call.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }
    public String getDate_nps_call() {
        if (date_nps_call == null){
            return " ";
        } else {
            return date_nps_call.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }
    public String getCreate_date_position() {
        if (create_date_position == null){
            return " ";
        } else {
            return create_date_position.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

}

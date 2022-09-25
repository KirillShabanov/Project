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
public class ReportCallForVASModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long num_order;
    @Column
    private String brand;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_order;
    @Column
    private String vin;
    @Column
    private String client_name;
    @Column
    private String master_receiver_name;
    @Column
    private Double nps;

    public String getDate_order() {
        if (date_order == null){
            return " ";
        } else {
            return date_order.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }
}

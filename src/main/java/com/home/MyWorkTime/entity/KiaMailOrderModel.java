package com.home.MyWorkTime.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "order_outfit")
@NoArgsConstructor
@AllArgsConstructor
public class KiaMailOrderModel {

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
    private String client_name;
    @Column
    private String phone;
    @Column
    private String status_1;
    @Column
    private String status_2;
}

package com.home.MyWorkTime.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private Date date_arrival;
    @Column
    private Date date_release;
    @Column
    private Date date_sale;
    @Column
    private Date create_date_position;
}

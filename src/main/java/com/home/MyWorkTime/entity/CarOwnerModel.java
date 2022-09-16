package com.home.MyWorkTime.entity;


import lombok.*;
import javax.persistence.*;


@Data
@Entity
@Table(name = "car_owner")
@NoArgsConstructor
@AllArgsConstructor
public class CarOwnerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long FK_owner;
    @Column
    private Long FK_vin;
    @Column
    private Long FK_automobile;

}

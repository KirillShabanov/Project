package com.home.MyWorkTime.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Data
@Entity
@Table(name = "car_owner_multibrand")
@NoArgsConstructor
@AllArgsConstructor
public class CarOwnerMultibrandModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long FK_owner;
    @Column
    private Long FK_vin;
    @Column
    private Long FK_brand;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate create_date_position;

    public String getCreate_date_position() {
        if (create_date_position == null){
            return " ";
        } else {
            return create_date_position.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }
}

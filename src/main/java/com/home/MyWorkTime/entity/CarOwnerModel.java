package com.home.MyWorkTime.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


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

    @JsonIgnore
    @ManyToMany (mappedBy = "autoForOWNERModelSet")
    @ToString.Exclude
    private List<AutoForTOModel> autoForOWNERModelSet;
    @JsonIgnore
    @ManyToMany (mappedBy = "carBrandModelSet")
    @ToString.Exclude
    private List<CarBrandModel> carBrandModelSet;
    @JsonIgnore
    @ManyToMany (mappedBy = "clientCardModelSet")
    @ToString.Exclude
    private List<ClientCardModel> clientCardModelSet;

}

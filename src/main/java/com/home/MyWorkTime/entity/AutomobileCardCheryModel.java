package com.home.MyWorkTime.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Entity
@Table(name = "automobile_card_chery")
@NoArgsConstructor
@AllArgsConstructor
public class AutomobileCardCheryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String vin;
    @Column
    private String reg_num;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_release;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_sale;
    @Column
    private Long FK_brand;

    public String date_release() {
        if (date_release == null){
            return " ";
        } else {
            return date_release.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

    public String date_sale() {
        if (date_sale == null){
            return " ";
        } else {
            return date_sale.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "car_owner",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "FK_vin")
    )
    private List<AutomobileCardCheryModel> automobileCardKiaCherySet;
}

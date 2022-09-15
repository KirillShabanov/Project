package com.home.MyWorkTime.entity;


import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "automobile_card_kia")
@NoArgsConstructor
@AllArgsConstructor
public class AutomobileCardKiaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String vin;
    @Column
    private String alter_vin;
    @Column
    private String reg_num;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_release;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_sale;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AutomobileCardKiaModel that = (AutomobileCardKiaModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

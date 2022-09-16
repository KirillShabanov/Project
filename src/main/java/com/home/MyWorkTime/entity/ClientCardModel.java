package com.home.MyWorkTime.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Data
@Entity
@Table(name = "clients_card")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientCardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String client_full_name;
    @Column
    private String city;
    @Column
    private String address;
    @Column
    private Long phone;
    @Column
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public String getBirthday() {
        if (birthday == null){
            return " ";
        } else {
            return birthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }
}

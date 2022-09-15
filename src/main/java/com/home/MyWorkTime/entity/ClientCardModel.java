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
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClientCardModel that = (ClientCardModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

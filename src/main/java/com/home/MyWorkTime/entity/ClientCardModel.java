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

    public String birthday() {
        if (birthday == null){
            return " ";
        } else {
            return birthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "car_owner",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "FK_owner")
    )
    private List<ClientCardModel> clientCardModelSet;
}

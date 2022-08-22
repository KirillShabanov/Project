package com.home.MyWorkTime.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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
}

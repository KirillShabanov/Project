package com.home.MyWorkTime.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="category")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CategoryRepairModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String category;
}

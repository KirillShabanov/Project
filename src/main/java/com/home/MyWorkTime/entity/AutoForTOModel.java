package com.home.MyWorkTime.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.util.List;



@Data
@Entity
@Table(name = "auto")
@NoArgsConstructor
@AllArgsConstructor
public class AutoForTOModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String automobile;
    @Column
    private String modification;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "to_regulations",
    joinColumns = @JoinColumn(name = "id"),
    inverseJoinColumns = @JoinColumn(name = "FK_numTO")
    )
    private List<AutoForTOModel> autoForTOModelSet;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "car_owner",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "FK_automobile")
    )
    private List<AutoForTOModel> autoForOWNERModelSet;

}

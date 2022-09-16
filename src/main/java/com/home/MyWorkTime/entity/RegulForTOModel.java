package com.home.MyWorkTime.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Data
@Entity
@Table(name = "regulations")
@NoArgsConstructor
@AllArgsConstructor
public class RegulForTOModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String number_TO;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "to_regulations",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "FK_numTO")
    )
    private List<RegulForTOModel> regulForTOModelSet;

}
